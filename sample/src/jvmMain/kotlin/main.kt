import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.singleWindowApplication
import com.threemoly.sample.ExampleApp

fun main() {
    singleWindowApplication(
        title = "sample",
        state = WindowState(size = DpSize(500.dp, 500.dp)),
    ) {
        ExampleApp()
    }
}