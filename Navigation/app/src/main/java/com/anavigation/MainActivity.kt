package com.anavigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: MainActivityViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // find the "holder" for all fragments; create navController
        val navController = findNavController(R.id.navHostFragment)

        // for the bottom nav to work
        // `bottomNavView` is the id in the activity xml
        bottomNavView.setupWithNavController(navController)

        // add to setupActionBarWithNavController to remove back arrows
        // back btn on phone now goes to home, press again leaves app
       /* var appBarConfiguration = AppBarConfiguration( // had to adjust app/gradle
            topLevelDestinationIds = setOf (
                R.id.oneFragment,
                R.id.twoFragment,
                R.id.threeFragment,
                R.id.fourFragment
            )
        )*/

        // action bar should show the label of the fragment too
        setupActionBarWithNavController(navController) //appBarConfiguration
    }

    // to enable the back button
    override fun onSupportNavigateUp() =
        findNavController( R.id.navHostFragment).navigateUp()
}
