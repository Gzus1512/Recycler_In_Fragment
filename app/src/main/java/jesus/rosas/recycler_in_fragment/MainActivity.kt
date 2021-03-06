package jesus.rosas.recycler_in_fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import jesus.rosas.recycler_in_fragment.fragments.MainFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragment: Fragment = MainFragment.newInstance()

        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frameContainer, fragment, "main_fragment")
        transaction.commit()
    }
}