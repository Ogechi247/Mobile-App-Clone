package com.example.whatsappclone.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.whatsappclone.R
import com.example.whatsappclone.model.SampleData
//import com.example.whatsappclone.ui.theme.liteGrayColor
import java.text.SimpleDateFormat
import java.util.Date

@Composable
fun StatusScreen(){
    val date = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
    val strDate: String = date.format(Date())

    val listofStatusData = listOf(
        SampleData(name = "Diego",des = "make it ",imgirl = "sampleirl",strDate),
        SampleData(name = "Ik bro ",des = "make it easy",imgirl = "sampleirl",strDate),
        SampleData(name = "Umeh",des = "make ", imgirl = "sampleirl",strDate),
        SampleData(name = " Chinaza ",des = "it easy",imgirl = "sampleirl",strDate),
        SampleData(name = "Oge",des = "make it easy 0",imgirl = "sampleirl",strDate),
        SampleData(name = "Andriod presido",des = "make it easy 1",imgirl = "sampleirl",strDate),


    )
    val listofViewedData = listOf(
        SampleData(name = "Billions",des = "make it easy 2",imgirl = "sampleirl",strDate),
        SampleData(name = "chat 8",des = "make it easy 3",imgirl = "sampleirl",strDate),
        SampleData(name = "chat 9",des = "make it easy 4",imgirl = "sampleirl",strDate),
        SampleData(name = "chat 10",des = "make it easy 5",imgirl = "sampleirl",strDate),
        SampleData(name = "chat 11",des = "make it easy 6",imgirl = "sampleirl",strDate),
        SampleData(name = "chat 12",des = "make it easy 7",imgirl = "sampleirl",strDate)
    )
LazyColumn(
    modifier = Modifier
        .background(Color.White)
) {
    item{

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),


            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_user)
                    , contentDescription = "My Story" ,
                    modifier = Modifier
                        .width(70.dp)
                        .height(70.dp)
                        .padding(5.dp)

                )

                Column(
                    modifier = Modifier.padding(10.dp)


                ) {
                    Text(
                        text ="My Story",
                        fontSize = 15.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier =Modifier.padding(2.dp) )
                    Text(
                        text ="Tap to add status update",
                        fontSize = 14.sp,
                        color = Color.Gray,
                        fontWeight = FontWeight.Normal

                    )


                }




            }

        }

    item {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.LightGray)
        ) {
            Text(
                text = "Recent updates",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, top = 8.dp, bottom = 8.dp),
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal,
                color = Color.Black,

                )
        }
    }

     items( listofStatusData.size){ index->
         SampleStatusListItem(listofStatusData[index])

     }
    item {
        Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.LightGray)
    ) {
        Text(
            text ="Viewed updates",

            modifier = Modifier
                .padding(15.dp,5.dp,10.dp,5.dp),
            fontSize = 15.sp,
            fontWeight = FontWeight.Normal,
            color = Color.Black,


            )

    }

    }
    items(listofViewedData.size){index->
        SampleStatusListItem(listofViewedData[index])

    }

}


}

@Composable
fun SampleStatusListItem(data: SampleData) {
Column {
    Row(
        modifier = Modifier

            .padding(5.dp)
            .fillMaxWidth() ,
        verticalAlignment = Alignment.CenterVertically

    ){
        Image(
            painter = painterResource(id =R.drawable.ic_user ) ,
            contentDescription = "Status Image",
                modifier = Modifier
                    .width(70.dp)
                    .height(70.dp)
                    .padding(5.dp)
        )
        Column (
            modifier = Modifier
                .padding(5.dp)
                .fillMaxWidth()

        ){
            Text(text = data.name,
                fontSize = 15.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.padding(3.dp))

            Text(
                text = "Today, ${data.createdDate}",
                fontSize = 14.sp,
                color = Color.Gray,

            )

        }


    }

}


       }


