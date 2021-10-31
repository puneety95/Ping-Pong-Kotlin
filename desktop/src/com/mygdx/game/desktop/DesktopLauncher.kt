package com.mygdx.game.desktop

import kotlin.jvm.JvmStatic
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration
import com.badlogic.gdx.backends.lwjgl.LwjglApplication
import com.mygdx.game.MyGdxGame

//import ktx.app.KtxApplicationAdapter;
object DesktopLauncher {
    @JvmStatic
    fun main(arg: Array<String>) {
        //LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        //new LwjglApplication(new MyGdxGame(), config);
        val config = LwjglApplicationConfiguration()
        LwjglApplication(MyGdxGame(), config)
    }
}