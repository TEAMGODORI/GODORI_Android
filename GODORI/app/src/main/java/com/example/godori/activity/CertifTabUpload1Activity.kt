package com.example.godori.activity

import android.Manifest
import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.util.Log
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.FileProvider
import com.example.godori.R
import kotlinx.android.synthetic.main.activity_certif_tab_upload1.*
import kotlinx.android.synthetic.main.activity_certif_tab_upload2.*
import java.io.File
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*


class CertifTabUpload1Activity : AppCompatActivity() {
    @SuppressLint("ClickableViewAccessibility")
    private val TAG : String = "태그명"
    val TAKE_PICTURE: Int  = 1

    // 경로 변수와 요청변수 생성
    lateinit var mCurrentPhotoPath: String
    val REQUEST_TAKE_PHOTO: Int= 1

    @SuppressLint("SimpleDateFormat")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_certif_tab_upload1)

        //백버튼 눌렀을 때
        backBtn1.setOnClickListener {
            onBackPressed()
        }

        //다음 화면으로 넘어가기
        next1Btn.setOnClickListener {
            val intent = Intent(this, CertifTabUpload2Activity::class.java)
            startActivity(intent)
        }

        //사진 권한 설정
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED && checkSelfPermission(
                    Manifest.permission.WRITE_EXTERNAL_STORAGE
                ) == PackageManager.PERMISSION_GRANTED
            ) {
                Log.d(TAG, "권한 설정 완료")
            } else {
                Log.d(TAG, "권한 설정 요청")
                ActivityCompat.requestPermissions(
                    this@CertifTabUpload1Activity,
                    arrayOf(Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE),
                    1
                )
            }
        }

        //버튼 누르면 촬영하는 부분을 dispatchTakePictureIntent를 불러오게 수정
        Img_Upload.setOnClickListener { v ->
            when (v.id) {
                R.id.Img_Upload -> dispatchTakePictureIntent()
            }
        }
        //현재 시간 가져오기
        val now: Long = System.currentTimeMillis()

        //Date 형식으로 고치기
        val mDate = Date(now)

        //가져오고 싶은 형태로 가져오기 "2018-07-06 01:42:00"
        val simpleDate = SimpleDateFormat("yyyy/MM/dd\n hh:mm")
        val getTime: String = simpleDate.format(mDate)

        //5개 버튼
        time_Btn1.setText(getTime)
        time_Btn2.setText(getTime)
        time_Btn3.setText(getTime)
        time_Btn4.setText(getTime)
        time_Btn5.setText(getTime)

        time_RBtn1.setOnCheckedChangeListener(listener1)
        time_RBtn2.setOnCheckedChangeListener(listener2)

    }

    //라디오 버튼 멀티라인
    private var listener1: RadioGroup.OnCheckedChangeListener =
        RadioGroup.OnCheckedChangeListener { group, checkedId ->
            if (checkedId != -1) {
                time_RBtn2.setOnCheckedChangeListener(null)
                time_RBtn2.clearCheck()
                time_RBtn2.setOnCheckedChangeListener(listener2)
            }
        }

    //라디오 버튼 멀티라인
    private val listener2: RadioGroup.OnCheckedChangeListener =
        RadioGroup.OnCheckedChangeListener { group, checkedId ->
            if (checkedId != -1) {
                time_RBtn1.setOnCheckedChangeListener(null)
                time_RBtn1.clearCheck()
                time_RBtn1.setOnCheckedChangeListener(listener1)
            }
        }

    // 권한 요청
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        Log.d(TAG, "onRequestPermissionsResult")
        if (grantResults[0] == PackageManager.PERMISSION_GRANTED && grantResults[1] == PackageManager.PERMISSION_GRANTED) {
            Log.d(TAG, "Permission: " + permissions[0] + "was " + grantResults[0])
        }
    }

    // 카메라로 촬영한 영상을 가져오는 부분
    override fun onActivityResult(requestCode: Int, resultCode: Int, intent: Intent?) {
        super.onActivityResult(requestCode, resultCode, intent)
    // API 29 이상일 경우 미만일 경우 나누어 Bitmap 생성
        try {
            when (requestCode) {
                REQUEST_TAKE_PHOTO -> {
                    if (resultCode === RESULT_OK) {
                        val file = File(mCurrentPhotoPath)
                        val bitmap: Bitmap?
                        if (Build.VERSION.SDK_INT >= 29) {
                            val source = ImageDecoder.createSource(
                                contentResolver, Uri.fromFile(file)
                            )
                            try {
                                bitmap = ImageDecoder.decodeBitmap(source)
                                Img_Upload.setImageBitmap(bitmap)
                            } catch (e: IOException) {
                                e.printStackTrace()
                            }
                        } else {
                            try {
                                bitmap = MediaStore.Images.Media.getBitmap(
                                    this.contentResolver,
                                    Uri.fromFile(file)
                                )
                                if (bitmap != null) {
                                    Img_Upload.setImageBitmap(bitmap)
                                }
                            } catch (e: IOException) {
                                e.printStackTrace()
                            }
                        }
                    }
                }
            }
        } catch (error: Exception) {
            error.printStackTrace()
        }
    }
    // 사진 촬영 후 썸네일만 띄워줌. 이미지를 파일로 저장해야 함. 촬영한 사진을 이미지 파일로 저장하는 함수 createImageFile
    @SuppressLint("SimpleDateFormat")
    @Throws(IOException::class)
    private fun createImageFile(): File {
        val timeStamp = SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
        val imageFileName = "JPEG_" + timeStamp + "_"
        val storageDir: File? = getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        val image: File = File.createTempFile(imageFileName, ".jpg", storageDir)
        mCurrentPhotoPath = image.absolutePath
        return image
    }

    // 카메라 인텐트 실행하는 부분
    @SuppressLint("QueryPermissionsNeeded")
    private fun dispatchTakePictureIntent() {
        val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        var photoFile: File? = null
        photoFile = createImageFile()

        val photoURI: Uri =
            FileProvider.getUriForFile(this, "com.example.godori.fileprovider", photoFile)
        takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI)
        startActivityForResult(takePictureIntent, REQUEST_TAKE_PHOTO)
    }
//    @SuppressLint("ResourceType")
//    fun onClick(v: View) {
//        // TODO Auto-generated method stub
//        when (v.getId()) {
//            R.id.btn_id_confirm -> {
//                if (time_RBtn1.getCheckedRadioButtonId() > 0) {
//                    val radioButton: View =
//                        time_RBtn1.findViewById(time_RBtn1.checkedRadioButtonId)
//                    val radioId: Int = time_RBtn1.indexOfChild(radioButton)
//                    val btn = time_RBtn1.getChildAt(radioId) as RadioButton
//                } else if (time_RBtn2.getCheckedRadioButtonId() > 0) {
//                    val radioButton: View =
//                        time_RBtn2.findViewById(time_RBtn2.getCheckedRadioButtonId())
//                    val radioId: Int = time_RBtn2.indexOfChild(radioButton)
//                    val btn = time_RBtn2.getChildAt(radioId) as RadioButton
//                }
//            }
//        }
//    }
}

