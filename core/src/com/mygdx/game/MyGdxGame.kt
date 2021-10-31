package com.mygdx.game

import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Input
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import com.badlogic.gdx.math.Rectangle
import com.badlogic.gdx.utils.ScreenUtils
import java.awt.Canvas
import kotlin.math.atan2
import kotlin.math.cos
import kotlin.math.sin


//import java.awt.Toolkit


class MyGdxGame : ApplicationAdapter() {


  // var h=Gdx.graphics.getHeight()
    //var w=Gdx.graphics.width
    var player1: Float=150f
    var player2: Float=150f
    var canvas: Canvas? =null
    var circle_x:Float=500f
    var circle_y:Float=500f
    var theta:Float=-0.01f
    var dir:Int=1
    var player1_score:Int=0
    var player2_score:Int=0

   // var screenSize: Dimension = Toolkit.getDefaultToolkit().getScreenSize()Gdx.graphics.getwidth  var h :Int = Toolkit.getDefaultToolkit().getScreenSize().getHeight() as Int
   // var hh=Gdx.graphics.width


    private lateinit var renderer: ShapeRenderer
    private var font: BitmapFont? = null
   // var myFont = BitmapFont(Gdx.files.internal("bitmapfont/Amble-Regular-26.fnt"))
    private var batch: SpriteBatch? = null
    override fun create() {
        renderer = ShapeRenderer()
        batch = SpriteBatch()
        font = BitmapFont()
        font!!.setColor(Color.BLACK)
        font!!.data.setScale(2f)
        //batch= SpriteBatch()
       var  rect = Rectangle()
        //println(hh)
       // println(hh)

    }

    override fun render() {
      ScreenUtils.clear(250f, 250f, 250f, 1f)
          // println(h)
        //println(w)
      //  batch!!.begin()

        //batch!!.draw( raindrop.x,raindrop.y)
      //  renderer.begin(ShapeRenderer.ShapeType.Filled);

        //renderer.rectLine(0f,0f,50f,50f,10f);
       // ScreenUtils.clear(0f, 0f, 0f, 1f)
        //ScreenUtils.clear(250f, 250f, 250f, 1f)

        //renderer.Color(Color.RED)


        //renderer.end();
      //  batch!!.end()
        Gdx.gl.glClearColor(.25f, .25f, .25f, 1f);
       // Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        handleInput()
        renderer.begin(ShapeRenderer.ShapeType.Filled)
        renderer.setColor(0f, 1f, 0f, 1f)
        renderer.circle(circle_x,   circle_y, 10f)
        renderer.rect(70f,player1,10f,100f)
        renderer.rect(1200f,player2,10f,100f)
        renderer.setColor(1f, 0f, 0f, 1f)
       // renderer.circle(70f,   player1, 1f)
        //renderer.circle(70f,   player1+50, 1f)
        check_collision()
      circle_path()
        renderer.end();
        batch!!.begin();
        font!!.draw(batch, player1_score.toString(), 505f, 700f);
        font!!.draw(batch, player2_score.toString(), 705f, 700f);
        batch!!.end();



/*
        handleInput()
        logic()
        draw()
        */


    }
    private fun circle_path(){
        circle_x= (circle_x) +(10f * cos(theta))
        circle_y=circle_y+(10f * sin(theta))
              /* println(theta)
        println(circle_x)
        println(circle_y)
        println(player1)

               */
        // println(circle_y)
    }
    private fun check_collision(){
        var prev_theta:Float
        if(circle_x<=70f+24f && (circle_y<=player1+100f && circle_y>=player1-100f))
        {
            println(circle_y)
            println(player1)
            println("Valies")


                //  prev_theta=theta * (-1)
                // dir=1
               // theta =atan2( (circle_y - player1) / (circle_x - player1))
            theta =atan2( (circle_y - player1) ,(circle_x - player1))

              //  theta = theta * (-1)


        //   theta= (theta+prev_theta) /2


            if(circle_y<=player1+50f)
            {
                println("UES")
            //    theta=-theta // go dow
                theta=3.14f+theta // go dow -
                return
            }
            theta=3.14f-theta // go up -
                println("UE--------S")




        }
        if(circle_x>1200f -24f && (circle_y<=player2+100f && circle_y>=player2-100f))
        {
           // dir=-1
            theta=atan2 ((circle_y - player2), (circle_x-player2))

        //    theta=3.14f-theta
          // theta
            //  =(1/theta) * (-1)
           //theta=theta * (-1)
           // println(circle_y)
          //  println(circle_x)
            if(circle_y<=player1+50f)
            {
                println("UES")
                //    theta=-theta // go dow
                theta=3.14f+theta // go dow -
                return
            }
            theta=3.14f-theta // go up -
            println("UE--------S")



        }
        if(circle_y>700f){

            //theta=(1/theta) * (-1)
           theta=theta * (-1)
           // theta=3.14f-theta

        }
        if(circle_y<80){
           // theta=3.14f-theta
           theta=theta * (-1)
        }
        if(circle_x>1210f){
            theta=3.14f-theta
            player1_score=player1_score +1
          // dir=dir *(-1)
        }
        if(circle_x<50f){
            theta=3.14f-theta
            player2_score=player1_score+1
            //dir=dir *(-1)
        }
    }
    private fun handleInput() {
        //Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            player1 = player1 - 5f
        } else if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            player1 = player1 + 5f
        }
        else if (Gdx.input.isKeyPressed(Input.Keys.J)) {
            player2 = player2 + 5f
        }
        else if (Gdx.input.isKeyPressed(Input.Keys.L)) {
            player2 = player2 - 5f
        }
    }



}