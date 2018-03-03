package zakharvoit.com.foodhackapp.common

import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {
    abstract val fragmentContainer: Int

    fun addToBackStack(fragment: Fragment, name: String) {
        supportFragmentManager
                .beginTransaction()
                .add(fragmentContainer, fragment)
                .addToBackStack(name)
                .commit()
    }
}
