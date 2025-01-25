package com.example.whatsappclone.view

import androidx.compose.material3.Text
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
//import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign.Companion.End
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.whatsappclone.R
import com.example.whatsappclone.model.SampleData
import com.example.whatsappclone.ui.theme.liteColor

import java.text.SimpleDateFormat
import java.util.Date

@Composable
fun ChatsScreen(navController: NavHostController) {
    val date = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
    val strDate: String = date.format(Date())

    val listofData = listOf(
        SampleData(name = "Diego",des = "make it ",imgirl = "sampleirl",strDate),
        SampleData(name = "Ik bro ",des = "make it easy",imgirl = "sampleirl",strDate),
        SampleData(name = "Umeh",des = "make ", imgirl = "sampleirl",strDate),
        SampleData(name = " Chinaza ",des = "it easy",imgirl = "sampleirl",strDate),
        SampleData(name = "Oge",des = "make it easy 0",imgirl = "sampleirl",strDate),
        SampleData(name = "Andriod presido",des = "make it easy 1",imgirl = "sampleirl",strDate),
        SampleData(name = "Billions",des = "make it easy 2",imgirl = "sampleirl",strDate),
        SampleData(name = "chat 8",des = "make it easy 3",imgirl = "sampleirl",strDate),
        SampleData(name = "chat 9",des = "make it easy 4",imgirl = "sampleirl",strDate),
        SampleData(name = "chat 10",des = "make it easy 5",imgirl = "sampleirl",strDate),
        SampleData(name = "chat 11",des = "make it easy 6",imgirl = "sampleirl",strDate),
        SampleData(name = "chat 12",des = "make it easy 7",imgirl = "sampleirl",strDate)


    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            //.padding(top = 8.dp)
            //.padding(WindowInsets.statusBars.asPaddingValues())
            //.wrapContentSize(Alignment.Center)

    ) {
        LazyColumn(
            modifier = Modifier.padding(0.0.dp)
        ) {
            items(listofData.size){index->
                SampleDataListItem(listofData[index],navController)



            }

        }

    }
}


@Composable
fun SampleDataListItem(data: SampleData, navController: NavHostController){
    Column(
        modifier =  Modifier.padding(4.dp)
    ) {
    Row(
    modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 8.dp) //.fillMaxSize()
        .clickable { navController.navigate("whats_app_chats") }

    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_user,),
            contentDescription ="image" ,
            modifier = Modifier
                .width(60.dp)
                .height(60.dp)
                //.padding(5.dp)
                .clip(RoundedCornerShape(5.dp))

            )
        Spacer(modifier = Modifier.width(8.dp))
        Column(
            modifier = Modifier//
                .weight(0.7f)
                .padding(vertical = 10.dp)// .padding(10.dp)
        ){
            Row(
                modifier = Modifier.fillMaxWidth()
            ){
                Text( text = data.name,
                    modifier = Modifier
                        .weight(1.0f),
                       fontSize = 15.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )


                Text( text = data.createdDate,
                    modifier = Modifier
                        .weight(1f),
                    textAlign = End,
                    fontSize = 12.sp,
                        fontWeight = FontWeight.Normal,
                        color = Color.Gray

                    )




            }
            Spacer(modifier = Modifier.padding(5.dp))

            Text( text = data.des,
                fontSize = 12.sp,
                fontWeight = FontWeight.Normal,
                color = Color.Black
            )
            Spacer(modifier = Modifier.padding(5.dp))
            Divider(color = liteColor, thickness = 0.5.dp, modifier = Modifier.padding(horizontal = 8.dp))

        }

}
    }

}

