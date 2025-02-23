package com.example.diceapp
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.diceapp.R
import kotlin.random.Random


class MainActivity: ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContent(){
            MainWindow()
        }
    }
}

@Composable
fun MainWindow(){
    var number by remember { mutableStateOf("") }
    Box(){

        Image(
            painter = painterResource(id = R.drawable.hello),
            contentDescription = "BG-IMAGE",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Column(
            Modifier.fillMaxWidth().height(250.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ){
            Text("Roll A Dice!", fontSize = 50.sp, fontFamily = FontFamily.Cursive, fontWeight = FontWeight.Bold)
        }

        Column(Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ){

            when(number){
                "1" -> DiceImage(R.drawable.one)
                "2" -> DiceImage(R.drawable.two)
                "3" -> DiceImage(R.drawable.threee)
                "4" -> DiceImage(R.drawable.four)
                "5" -> DiceImage(R.drawable.five)
                "6" -> DiceImage(R.drawable.six)
            }



            Spacer(Modifier.height(15.dp))

            Text(number, fontSize = 25.sp, fontWeight = FontWeight.Bold)

            Spacer(Modifier.height(15.dp))


            Button(onClick = {
                number = generateNumber().toString()

            }) {
                Text("Throw Dice")
            }
        }
    }
}

fun generateNumber(): Int{
    var num = Random.nextInt(6)+1
    return num
}

@Composable
fun DiceImage(img : Int){
    Image(
        painter = painterResource(img),
        contentDescription = "DiceImage",
        modifier = Modifier.size(100.dp)
    )
}



