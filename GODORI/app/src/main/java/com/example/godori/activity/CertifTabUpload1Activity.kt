package com.example.godori.activity

import android.Manifest
import android.annotation.SuppressLint
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.*
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.util.Log
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.FileProvider
import com.example.godori.R
import kotlinx.android.synthetic.main.activity_certif_tab_upload1.*
import kotlinx.android.synthetic.main.activity_certif_tab_upload2.*
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*


class CertifTabUpload1Activity : AppCompatActivity() {
    @SuppressLint("ClickableViewAccessibility")
    private val TAG: String = "태그명"
//    val TAKE_PICTURE: Int = 1

    // 경로 변수와 요청변수 생성
    lateinit var mCurrentPhotoPath: String //문자열 형태의 사진 경로값 (초기값을 null로 시작하고 싶을 때 - lateinti var)

    private var imgUri: Uri? = null
    private var photoURI: Uri? = null
    private var albumURI: Uri? = null


//    val REQUEST_TAKE_PHOTO: Int= 1 //카메라 사진 촬영 요청 코드 *임의로 값 입력
//    val REQUEST_IMAGE_PICK = 10 //갤러리에서 사진 가져오기

    private val FROM_CAMERA = 0
    private val FROM_ALBUM = 1
    private val IMAGE_CROP = 2

    @RequiresApi(Build.VERSION_CODES.P)
    @SuppressLint("SimpleDateFormat", "WrongThread")
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

//        //TedPermission 라이브러리 -> 카메라 권한 획득
//        val permissionlistener: PermissionListener = object : PermissionListener() {
//            fun onPermissionGranted() {
//                Toast.makeText(this@CertifTabUpload1Activity, "Permission Granted", Toast.LENGTH_SHORT)
//                    .show()
//            }
//
//            fun onPermissionDenied(deniedPermissions: ArrayList<String?>) {
//                Toast.makeText(
//                    this@CertifTabUpload1Activity,
//                    "Permission Denied\n$deniedPermissions",
//                    Toast.LENGTH_SHORT
//                ).show()
//            }
//        }
//
//        TedPermission(this)
//            .setPermissionListener(permissionlistener)
//            .setDeniedMessage("If you reject permission,you can not use this service\n\nPlease turn on permissions at [Setting] > [Permission]")
//            .setPermissions(Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA)
//            .check()

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
//                R.id.Img_Upload -> dispatchTakePictureIntent()
                R.id.Img_Upload -> makeDialog()
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

        //버튼 누르면 글쓰기
        time_Btn1.setOnClickListener { v ->
            when (v.id) {
//                R.id.time_Btn1 -> writeOnDrawable(getTime, 50)
            }
        }

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

//    // 카메라로 촬영한 영상을 가져오는 부분, 가져온 사진 뿌리기
//    @SuppressLint("SimpleDateFormat")
//    @RequiresApi(Build.VERSION_CODES.P)
//    override fun onActivityResult(requestCode: Int, resultCode: Int, intent: Intent?) {
//        super.onActivityResult(requestCode, resultCode, intent)
//    // API 29 이상일 경우 미만일 경우 나누어 Bitmap 생성
//        try {
//            when (requestCode) {
//                REQUEST_TAKE_PHOTO -> {
//                    if (resultCode === RESULT_OK) {
//                        val file = File(mCurrentPhotoPath)
//                        val bitmap: Bitmap?
//                        if (Build.VERSION.SDK_INT >= 29) {
//                            val source = ImageDecoder.createSource(
//                                contentResolver, Uri.fromFile(file)
//                            )
//                            try {
//                                bitmap = ImageDecoder.decodeBitmap(source)
//                                Img_Upload.setImageBitmap(bitmap)
//                                Img_Upload.setImageBitmap(writeOnDrawable(bitmap, "song"))
//
//                            } catch (e: IOException) {
//                                e.printStackTrace()
//                            }
//                        } else {
//                            try {
//                                bitmap = MediaStore.Images.Media.getBitmap(
//                                    this.contentResolver,
//                                    Uri.fromFile(file)
//                                )
//                                if (bitmap != null) {
//                                    Img_Upload.setImageBitmap(bitmap)
//                                }
//                            } catch (e: IOException) {
//                                e.printStackTrace()
//                            }
//                        }
//                    } else {
//                        Toast.makeText(
//                            this@CertifTabUpload1Activity,
//                            "사진찍기를 취소하였습니다.",
//                            Toast.LENGTH_SHORT
//                        ).show();
//                    }
//                }
//            }
//        } catch (error: Exception) {
//            error.printStackTrace()
//        }
//    }
//    // 사진 촬영 후 썸네일만 띄워주므로 이미지를 파일로 저장해야 함. 촬영한 사진을 이미지 파일로 저장하는 함수 createImageFile
//    // 사진을 찍기 전, 사진이 저장되는 임시 파일을 생성
//    @SuppressLint("SimpleDateFormat")
//    @Throws(IOException::class)
//    private fun createImageFile(): File {
//        // 이미지 파일 이름
//        val timeStamp = SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
//        val imageFileName = "JPEG_" + timeStamp + "_"
//
//        // 이미지가 저장될 폴더 이름
//        val storageDir: File? = getExternalFilesDir(Environment.DIRECTORY_PICTURES)
//
//        // 빈 파일 생성
//        val image: File = File.createTempFile(imageFileName, ".jpg", storageDir)
//        mCurrentPhotoPath = image.absolutePath
//        return image
//    }

    //다이얼로그 카메라, 앨범선택
    private fun makeDialog() {
        val alt_bld: android.app.AlertDialog.Builder =
            android.app.AlertDialog.Builder(
                this@CertifTabUpload1Activity,
                R.style.MyAlertDialogStyle
            )
        alt_bld.setTitle("사진 업로드").setIcon(R.drawable.gr_img_info_excersie).setCancelable(
            false
        ).setPositiveButton("사진촬영",
            DialogInterface.OnClickListener { dialog, id ->
                Log.v("알림", "다이얼로그 > 사진촬영 선택")

                // 사진 촬영 클릭
                takePhoto()
            }).setNeutralButton("앨범선택",
            DialogInterface.OnClickListener { dialogInterface, id ->
                Log.v("알림", "다이얼로그 > 앨범선택 선택")

                //앨범에서 선택
                selectAlbum()
            }).setNegativeButton("취소   ",
            DialogInterface.OnClickListener { dialog, id ->
                Log.v("알림", "다이얼로그 > 취소 선택")

                // 취소 클릭. dialog 닫기.
                dialog.cancel()
            })
        val alert: android.app.AlertDialog? = alt_bld.create()
        if (alert != null) {
            alert.show()
        }
    }

    //사진 찍기 클릭
    @SuppressLint("QueryPermissionsNeeded")
    private fun takePhoto() {
        // 촬영 후 이미지 가져옴

        val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        if (takePictureIntent.resolveActivity(packageManager) != null) {
            var photoFile: File? = null
            try {
                photoFile = createImageFile() // 사진찍은 후 저장할 임시 파일
            } catch (ex: IOException) {
                Toast.makeText(applicationContext, "createImageFile Failed", Toast.LENGTH_LONG)
                    .show()
            }
            if (photoFile != null) {
                photoURI = Uri.fromFile(photoFile) // 임시 파일의 위치,경로 가져옴
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI) // 임시 파일 위치에 저장
                startActivityForResult(takePictureIntent, FROM_CAMERA)
            }
        } else {
            Toast.makeText(this, "저장공간이 접근 불가능한 기기입니다", Toast.LENGTH_SHORT).show()
            return
        }
    }


    @Throws(IOException::class)
    fun createImageFile(): File {
        val imgFileName = System.currentTimeMillis().toString() + ".jpg"
        var imageFile: File? = null
        val storageDir =
            File(Environment.getExternalStorageDirectory().toString() + "/Pictures", "ireh")
        if (!storageDir.exists()) {
            Log.v("알림", "storageDir 존재 x $storageDir")
            storageDir.mkdirs()
        }
        Log.v("알림", "storageDir 존재함 $storageDir")
        imageFile = File(storageDir, imgFileName)
        mCurrentPhotoPath = imageFile.absolutePath
        return imageFile
    }

    //앨범 선택 클릭
    private fun selectAlbum() {
        //앨범 열기
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = MediaStore.Images.Media.CONTENT_TYPE
        intent.type = "image/*"
        startActivityForResult(intent, FROM_ALBUM)
    }

    fun galleryAddPic() {
        val mediaScanIntent = Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE)
        val f: File = File(mCurrentPhotoPath)
        val contentUri = Uri.fromFile(f)
        mediaScanIntent.data = contentUri
        sendBroadcast(mediaScanIntent)
        Toast.makeText(this, "사진이 저장되었습니다", Toast.LENGTH_SHORT).show()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode != RESULT_OK) {
            return
        }
        when (requestCode) {
            FROM_ALBUM -> {
                //앨범에서 가져오기
                if (data != null) {
                    if (data.data != null) {
                        try {
                            var albumFile: File? = null
                            albumFile = createImageFile()
                            photoURI = data.data
                            albumURI = Uri.fromFile(albumFile)
                            galleryAddPic()
                            Img_Upload.setImageURI(photoURI)

                            //cropImage();
                        } catch (e: Exception) {
                            e.printStackTrace()
                            Log.v("알림", "앨범에서 가져오기 에러")
                        }
                    }
                }
            }
            FROM_CAMERA -> {
                //카메라 촬영
                try {
                    Log.v("알림", "FROM_CAMERA 처리")
                    galleryAddPic()
                    Img_Upload.setImageURI(imgUri)
                } catch (e: Exception) {
                    e.printStackTrace()
                }

//                if (resultCode === RESULT_OK) {
//                    val file = File(mCurrentPhotoPath)
//                    val bitmap: Bitmap?
//                    if (Build.VERSION.SDK_INT >= 29) {
//                        val source = ImageDecoder.createSource(
//                            contentResolver, Uri.fromFile(file)
//                        )
//                        try {
//                            bitmap = ImageDecoder.decodeBitmap(source)
//                            Img_Upload.setImageBitmap(bitmap)
//
//                        } catch (e: IOException) {
//                            e.printStackTrace()
//                        }
//                    } else {
//                        try {
//                            bitmap = MediaStore.Images.Media.getBitmap(
//                                this.contentResolver,
//                                Uri.fromFile(file)
//                            )
//                            if (bitmap != null) {
//                                Img_Upload.setImageBitmap(bitmap)
//                            }
//                        } catch (e: IOException) {
//                            e.printStackTrace()
//                        }
//                    }
//                } else {
//                    Toast.makeText(
//                        this@CertifTabUpload1Activity,
//                        "사진찍기를 취소하였습니다.",
//                        Toast.LENGTH_SHORT
//                    ).show();
//                }
            }
        }
    }


//    // 카메라 인텐트 실행하는 부분
//    @SuppressLint("QueryPermissionsNeeded")
//    private fun dispatchTakePictureIntent() {
//        val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
//        var photoFile: File? = null
//        photoFile = createImageFile()
//
//        val photoURI: Uri =
//            FileProvider.getUriForFile(this, "com.example.godori.fileprovider", photoFile)
//        takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI)
//        startActivityForResult(takePictureIntent, REQUEST_TAKE_PHOTO)
//    }


    // 비트맵에 글쓰기
    @RequiresApi(Build.VERSION_CODES.P)
    private fun writeOnDrawable(bm: Bitmap, text: String?): Bitmap? {
        val bitmap = Bitmap.createBitmap(380, 380, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(bitmap)

        // 캔버스에 받아온 bm 넣기
        canvas.setBitmap(bm)

        val paint = Paint()
        paint.setColor(Color.WHITE)
        paint.setTextSize(20.toFloat())
        paint.setTextAlign(Paint.Align.CENTER)


        // 도화지에 좌표로 표시하기
        val rect = RectF()
        rect[160f, 140f, 360f] = 640f

        if (text != null) {
            canvas.drawText(
                text,
                190F,
                190F,
                paint
            )
        }
        return bm
    }

    //갤러리에 저장
    private fun savePhoto(bitmap: Bitmap) {
        //사진 폴더에 저장하기 위한 경로 선언
        val folderPath = Environment.getExternalStorageDirectory().absolutePath + "/Pictures/"
        val timestamp: String = SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
        val fileName = "${timestamp}.jpeg"
        val folder = File(folderPath)
        if (!folder.isDirectory) {//해당 경로에 폴더가 존재하지
            folder.mkdir() // make directory의 줄임말로 해당경로에 폴더 자동으로
        }
        //실제적인 저장 처리
        val out = FileOutputStream(folderPath + fileName)
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, out)
        Toast.makeText(this, "사진이 앨범에 저장되었습니다.", Toast.LENGTH_SHORT).show()
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

