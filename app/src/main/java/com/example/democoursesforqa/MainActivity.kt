
package com.example.democoursesforqa

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.democoursesforqa.ui.theme.DemoCoursesForQATheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            DemoCoursesForQATheme {
                CourseCatalogScreen()
            }
        }
    }
}