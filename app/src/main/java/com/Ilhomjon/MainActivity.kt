package com.Ilhomjon

import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.ImageView.ScaleType.CENTER_CROP
import androidx.core.view.isInvisible
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.math.log
import kotlin.random.Random as Random1

class MainActivity : AppCompatActivity() {





    var count = -1
    var hasRasmOchildi = 0
    var rasmOchildi = -1
    var rasmOchildiFram = -1
    var animatsiyaJarayoni = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rasmlar = arrayListOf<Int>(R.mipmap.ic_tabiat_rasm1_foreground, R.mipmap.ic_tabiat_rasm2_foreground,
            R.mipmap.ic_moto_rasm3_foreground)
        val framlar = arrayListOf<FrameLayout>(frm1, frm2, frm3, frm4, frm5, frm6)
        val imagelar = arrayListOf<ImageView>(rasm1, rasm2, rasm3, rasm4, rasm5, rasm6)



        val animation: Animation = AnimationUtils.loadAnimation(this, R.anim.rasm_anim)
        animation.setAnimationListener(object : Animation.AnimationListener{
            override fun onAnimationRepeat(animation: Animation?) {

            }

            override fun onAnimationEnd(animation: Animation?) {
                imagelar[countFram].setImageResource(rasmlar[count])
                val animation2 = AnimationUtils.loadAnimation(this@MainActivity, R.anim.rasm_anim_2)
                framlar[countFram].startAnimation(animation2)

                animation2.setAnimationListener(object : Animation.AnimationListener{
                    override fun onAnimationRepeat(animation: Animation?) {

                    }

                    override fun onAnimationEnd(animation: Animation?) {
                        println("hasRasmOchildi=$hasRasmOchildi, ramOchildi=$rasmOchildi")
                        println("count=$count ")
                        if (hasRasmOchildi ==2 && rasmOchildi == count && rasmOchildiFram != countFram){

                            val animationOlibTashlash = AnimationUtils.loadAnimation(this@MainActivity, R.anim.rasm_anim)

                            framlar[rasmOchildiFram].startAnimation(animationOlibTashlash)
                            framlar[countFram].startAnimation(animationOlibTashlash)

                            animationOlibTashlash.setAnimationListener(object : Animation.AnimationListener{
                                override fun onAnimationRepeat(animation: Animation?) {

                                }

                                override fun onAnimationEnd(animation: Animation?) {
                                    framlar[rasmOchildiFram].visibility = View.INVISIBLE
                                    framlar[countFram].visibility = View.INVISIBLE
                                    hasRasmOchildi=0
                                    rasmOchildi=-1
                                    animatsiyaJarayoni = false
                                }

                                override fun onAnimationStart(animation: Animation?) {
                                    animatsiyaJarayoni = true
                                }

                            })


                        }else{
                            println("else =====")
                            if (hasRasmOchildi==2) {
                                println("else if ====")

                                val animationKeyingi = AnimationUtils.loadAnimation(this@MainActivity, R.anim.rasm_anim_2)
                                framlar[rasmOchildiFram].startAnimation(animationKeyingi)
                                if (rasmOchildiFram != countFram)
                                    framlar[countFram].startAnimation(animationKeyingi)
                                imagelar[rasmOchildiFram].setImageResource(R.mipmap.ic_yulduzcha_foreground)
                                imagelar[countFram].setImageResource(R.mipmap.ic_yulduzcha_foreground)
                                hasRasmOchildi=0
                                rasmOchildi=-1
                                animationKeyingi.setAnimationListener(object : Animation.AnimationListener{
                                    override fun onAnimationRepeat(animation: Animation?) {
                                    }

                                    override fun onAnimationEnd(animation: Animation?) {
                                        animatsiyaJarayoni = false
                                    }

                                    override fun onAnimationStart(animation: Animation?) {
                                    }

                                })
                            }
                        }
                        animatsiyaJarayoni = false
                    }

                    override fun onAnimationStart(animation: Animation?) {

                    }

                })


            }

            override fun onAnimationStart(animation: Animation?) {
                animatsiyaJarayoni = true
            }
        })


        var rasmNechtaligi = -1

        frm1.setOnClickListener {
            if (!animatsiyaJarayoni) {
                if (rasmOchildi == -1) {
                    rasmOchildi = 0
                    rasmOchildiFram = 0
                }

                hasRasmOchildi++
                count = 0
                countFram = 0
                framlar[0].startAnimation(animation)
                rasmNechtaligi = 0
                rasmNechtaligi = 0
            }
        }
        frm2.setOnClickListener {
            if (!animatsiyaJarayoni) {
                if (rasmOchildi == -1) {
                    rasmOchildi = 1
                    rasmOchildiFram = 1
                }

                hasRasmOchildi++
                count = 1
                countFram = 1
                framlar[1].startAnimation(animation)
                rasmNechtaligi = 1
            }
        }
        frm3.setOnClickListener {
            if (!animatsiyaJarayoni) {
                if (rasmOchildi == -1) {
                    rasmOchildi = 2
                    rasmOchildiFram = 2
                }

                hasRasmOchildi++
                count = 2
                countFram = 2
                framlar[2].startAnimation(animation)
                rasmNechtaligi = 2
            }
        }
        frm4.setOnClickListener {
            if (!animatsiyaJarayoni) {
                if (rasmOchildi == -1) {
                    rasmOchildi = 0
                    rasmOchildiFram = 3
                }

                hasRasmOchildi++
                count = 0
                countFram = 3
                framlar[3].startAnimation(animation)
                rasmNechtaligi = 3
            }
        }
        frm5.setOnClickListener {
            if (!animatsiyaJarayoni) {
                if (rasmOchildi == -1) {
                    rasmOchildi = 1
                    rasmOchildiFram = 4
                }

                hasRasmOchildi++
                count = 1
                countFram = 4
                framlar[4].startAnimation(animation)
                rasmNechtaligi = 4
            }
        }
        frm6.setOnClickListener {
            if (!animatsiyaJarayoni) {
                if (rasmOchildi == -1) {
                    rasmOchildi = 2
                    rasmOchildiFram = 5
                }

                hasRasmOchildi++
                count = 2
                countFram = 5
                framlar[5].startAnimation(animation)
                rasmNechtaligi = 5
            }
        }


    }
    var countFram = -1




    fun randomSon(n:Int):Int{
        return Random().nextInt(n)
    }
}