package com.example.godori.fragment


import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.os.Build
import android.os.Bundle
import android.text.style.ForegroundColorSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.godori.R
import com.example.godori.activity.CertifTabDetailActivity
import com.example.godori.activity.CertifTabUpload1Activity
import com.prolificinteractive.materialcalendarview.*
import com.prolificinteractive.materialcalendarview.CalendarDay.today
import kotlinx.android.synthetic.main.activity_certif_tab_upload1.*
import kotlinx.android.synthetic.main.fragment_certif_tab.*
import kotlinx.android.synthetic.main.fragment_certif_tab.view.*
import java.text.SimpleDateFormat
import java.time.format.DateTimeFormatter
import java.time.temporal.TemporalAccessor
import java.util.*
import kotlin.collections.ArrayList


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CertifTabFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CertifTabFragment : Fragment(), OnDateSelectedListener {

    @RequiresApi(Build.VERSION_CODES.O)
    private val FORMATTER = DateTimeFormatter.ofPattern("yyyy.MM.dd")

    @SuppressLint("ResourceType")
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_certif_tab, container, false)
        val materialCalendarView : MaterialCalendarView = view.findViewById(R.id.cal)


        materialCalendarView.state().edit()
            .setFirstDayOfWeek(Calendar.MONDAY)
            .setMinimumDate(CalendarDay.from(2020, 1, 1))
            .setMaximumDate(CalendarDay.from(2030, 12, 31))
            .setCalendarDisplayMode(CalendarMode.WEEKS)
            .commit()

        materialCalendarView.addDecorators(
            SundayDecorator(),
            SaturdayDecorator(),
            OneDayDecorator()
        )

//        calendarText = (TextView)findViewById(R.id.calendarText)



        // calendarText에 클릭하면 날짜 표시
        materialCalendarView.setOnDateChangedListener(OnDateSelectedListener { widget, date, selected ->
            calendarText.setText(String.format("%d년% d월 %d일 %d요일", date.year, date.month + 1, date.day))
        })

        materialCalendarView.setTileSizeDp(55)

        return view
    }

    class SundayDecorator : DayViewDecorator { //일요일 데코
        private val calendar = Calendar.getInstance()
        override fun shouldDecorate(day: CalendarDay): Boolean {
            day.copyTo(calendar)
            val weekDay = calendar[Calendar.DAY_OF_WEEK]
            return weekDay == Calendar.SUNDAY
        }

        override fun decorate(view: DayViewFacade) {
//            view.addSpan(ForegroundColorSpan(Color.RED))
        }
    }

    class SaturdayDecorator : DayViewDecorator { //토요일 데코
        private val calendar = Calendar.getInstance()
        override fun shouldDecorate(day: CalendarDay): Boolean {
            day.copyTo(calendar)
            val weekDay = calendar[Calendar.DAY_OF_WEEK]
            return weekDay == Calendar.SATURDAY
        }

        override fun decorate(view: DayViewFacade) { //토요일일 경우, 파란색
//            view.addSpan(ForegroundColorSpan(Color.BLUE))
        }
    }

    class OneDayDecorator : DayViewDecorator { //오늘 날짜에 표시
        private var date: CalendarDay?
        private val calendar = Calendar.getInstance()

        override fun shouldDecorate(day: CalendarDay): Boolean { //date가 day오늘 날짜랑 같은지 비교
            return date != null && day == date
        }

        override fun decorate(view: DayViewFacade) {
//            view.addSpan(StyleSpan(Typeface.BOLD))
//            view.addSpan(RelativeSizeSpan(1.4f))
            view.addSpan(ForegroundColorSpan(Color.RED))
//            view.setBackgroundDrawable(getDrawable(R.drawable.button_circle))
        }
        /**
         * We're changing the internals, so make sure to call [MaterialCalendarView.invalidateDecorators]
         */
        fun setDate(date: Date?) {
            this.date = CalendarDay.from(date)
        }

        init {
            date = CalendarDay.today()
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onDateSelected(
        widget: MaterialCalendarView,
        date: CalendarDay,
        selected: Boolean
    ) {
//        calendarText.setText(if (selected) FORMATTER.format(date.date) else "No Selection")
    }

    class CurrentDayDecorator(context: CertifTabFragment) : DayViewDecorator { //고치기
        private val drawable: Drawable?
            get() {
                TODO()
            }
        var currentDay = CalendarDay.from(Date())
        override fun shouldDecorate(day: CalendarDay): Boolean {
            return day == currentDay
        }

        override fun decorate(view: DayViewFacade) {
            view.setSelectionDrawable(drawable!!)
        }

        init {
//            drawable = ContextCompat.getDrawable(context, R.drawable.first_day_month)
        }

    }

    // 리사이클러뷰
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // item List 준비
        val personList = ArrayList<PersonForList>()
        for (i in 0 until 7) { // 이후 명수 가져오기
            personList.add(PersonForList("" + i + " 사람"))
        }

        // adapter 생성
        val adapter = certifRecyclerViewAdapter(personList, LayoutInflater.from(this.context))
        certifRecycler.adapter = adapter
        certifRecycler.layoutManager = GridLayoutManager(this.context, 2)

    }

    // 사람별 인증 리스트
    class PersonForList(val name: String) {

    }

    //인증탭 리사이클러뷰 어댑터
    class certifRecyclerViewAdapter(
        val itemList: ArrayList<PersonForList>,
        val inflater: LayoutInflater
    ):RecyclerView.Adapter<certifRecyclerViewAdapter.ViewHolder>() {

        @SuppressLint("RestrictedApi")
        inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) { //
            var personName: TextView
            var certifImg: ImageView

            init {
                personName = itemView.findViewById(R.id.personName)
                certifImg = itemView.findViewById(R.id.certifImg)

                // Person 아이템을 눌렀을 때
                itemView.setOnClickListener { view ->
//                    val posintion: Int = adapterPosition
//                    val personName = itemList.get(posintion).name

                    //CertifTabDetailActivity로 이동
                    val intent = Intent(view.context, CertifTabDetailActivity::class.java)
                    view.getContext().startActivity(intent)
                }
            }
        }

        // 아이템 하나가 들어갈 뷰를 만들고 뷰 홀더(*****)에 넣어줌
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = inflater.inflate(R.layout.item_certif_tab, parent, false)
            return ViewHolder(view)
        }

        //리스트의 전체 개수
        override fun getItemCount(): Int {
            return itemList.size
        }

        //뷰를 그리는 부분
        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.certifImg.setImageResource(R.drawable.certif_un)
            holder.personName.setText(itemList.get(position).name)
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        uploadBtn1.setOnClickListener {
            val intent = Intent(getActivity(), CertifTabUpload1Activity::class.java)
            startActivity(intent)
        }
    }

}