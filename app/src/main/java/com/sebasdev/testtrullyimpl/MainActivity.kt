package com.sebasdev.testtrullyimpl

import ai.trully.sdk.TrullySdk
import ai.trully.sdk.configurations.TrullyConfig
import ai.trully.sdk.configurations.TrullyStyles
import ai.trully.sdk.models.Environment
import ai.trully.sdk.models.ErrorData
import ai.trully.sdk.models.Texts
import ai.trully.sdk.models.TrackDetail
import ai.trully.sdk.models.TrackStep
import ai.trully.sdk.models.TrullyResponse
import ai.trully.sdk.protocols.listeners.TrullyListeners
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Base64
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(), TrullyListeners {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        findViewById<Button>(R.id.launchTrully)
            .setOnClickListener {
                initialize()
                onTap()
            }
    }

    private fun onTap() {
        TrullySdk.start(this, this)
    }

    private fun initialize() {
        val styles = TrullyStyles()
        styles.uiTexts.docType = Texts.PASSPORT

        styles.primaryColor = com.regula.common.R.color.red
        styles.disabledColor = com.regula.common.R.color.dark_green
        styles.backgroundColor = androidx.appcompat.R.color.button_material_dark

        styles.logo = ai.trully.sdk.R.drawable.logo
        styles.IDIcon = ai.trully.sdk.R.drawable.selfie
        styles.selfieIcon = ai.trully.sdk.R.drawable.ine
        styles.IdImage = ai.trully.sdk.R.drawable.ine
        styles.permission = ai.trully.sdk.R.drawable.ine
        styles.light = ai.trully.sdk.R.drawable.ine
        styles.cross = ai.trully.sdk.R.drawable.ine
        styles.showId = ai.trully.sdk.R.drawable.ine
        styles.check = ai.trully.sdk.R.drawable.ine
        styles.faceTimeout = ai.trully.sdk.R.drawable.ine
        styles.noLocation = ai.trully.sdk.R.drawable.ine
        styles.noCamera = ai.trully.sdk.R.drawable.ine
        styles.errorIcon = ai.trully.sdk.R.drawable.ine


//        val config = TrullyConfig(environment =  Environment.DEBUG,  style = styles, userID = "un-external-id", showIdView = true)
        val config = TrullyConfig(
            Environment.DEBUG,
            "test-sdk-kotlin",
            showIdView = true
        )

        TrullySdk.init("put your key here", config)
    }

    override fun onResult(response: TrullyResponse) {
        //Complete Decision Maker response
//        Log.d("TRULLY_SDK", response.decisionMaker.toString())
//        Log.d("TRULLY_TRACK", trackResponse.data.toString())

        //Short response
//        Log.d("TRULLY_SDK", response.shortResponse?.request_id.toString())
//        Log.d("TRULLY_SDK", response.shortResponse?.label.toString())
//        Log.d("TRULLY_SDK", response.shortResponse?.reason.toString())
//        Log.d("TRULLY_SDK", response.shortResponse?.request_date.toString())

        //Images - base64 string
//        Log.d("TRULLY_SDK", response.images?.selfieStr.toString()) //Selfie
//        Log.d("TRULLY_SDK", response.images?.documentStr.toString()) //Cropped document front
//        Log.d("TRULLY_SDK", response.images?.documentBackStr.toString()) //Cropped document back
//        Log.d("TRULLY_SDK", response.images?.documentCompleteStr.toString()) //Uncropped document front
//        Log.d("TRULLY_SDK", response.images?.documentBackCompleteStr.toString()) //Uncropped document back

        /*val selfie = response.images?.selfieStr?.let { base64ToBitmap(it) }
        val doc = response.images?.documentStr?.let { base64ToBitmap(it) }
        val docComplete = response.images?.documentCompleteStr?.let { base64ToBitmap(it) }
        val docBack = response.images?.documentBackStr?.let { base64ToBitmap(it) }
        val docBackComplete = response.images?.documentBackCompleteStr?.let { base64ToBitmap(it) }


        val userID = response.shortResponse?.userID
        val request_id = response.shortResponse?.request_id
        val label = response.shortResponse?.label
        val reason = response.shortResponse?.reason
        val request_date = response.shortResponse?.request_date*/

        /*ResponseData.getInstance().init(
            imagesBitmap = ImagesBitmap(
                selfie,
                doc,
                docComplete,
                docBack,
                docBackComplete
            ), shortResponse = ShortResponse(userID, request_id, label, reason, request_date)
        )

        val intent = Intent(this, ResultActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NO_ANIMATION
        startActivity(intent)*/
    }

    override fun onTrack(trackStep: TrackStep) {
        Log.d("onTrack", trackStep.toString())
    }

    override fun onTrackDetail(trackDetail: TrackDetail) {
        Log.d("onTrackDetail", trackDetail.toString())
    }

    override fun onError(errorData: ErrorData) {
        Log.d("onError", errorData.toString())
    }

    private fun base64ToBitmap(base64Str: String): Bitmap? {
        val imageBytes = Base64.decode(base64Str, Base64.DEFAULT)
        return BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.size)
    }
}