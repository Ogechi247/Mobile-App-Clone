package com.example.whatsappclone.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import java.text.SimpleDateFormat
import java.util.Date

@Composable
fun CallsScreen(){
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
    )
    {
        LazyColumn {
            items(listofData.size){ index->
                WhatsappCallList(listofData[index], index)


            }
        }
        
    }

}


@Composable
fun WhatsappCallList(sampleData: SampleData, index:Int) {
    Column(
        modifier = Modifier
            .padding(5.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ){
            Image(
               painter =  painterResource(id = R.drawable.ic_user),
                contentDescription = "User Image",
                modifier = Modifier
                    .width(80.dp)
                    .height(80.dp)
                    .padding(5.dp)
                    .weight(0.2f),

            )
            Column (
                modifier = Modifier
                    .padding(5.dp)
                    .weight(0.7f)
            ){
                Text(text = sampleData.name,
                    fontSize = 17.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,

                )
                Spacer(modifier = Modifier.padding(5.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Image(painter = painterResource(
                        if (index % 2 == 0){
                            R.drawable.ic_income_call

                        }else R.drawable.ic_outgoing_calls),
                      contentDescription ="Income & Outgoing calls icon ",
                    modifier = Modifier
                        .width(20.dp)
                        .height(20.dp)
                        .padding(0.dp, 0.dp, 3.dp, 0.dp)
                    )
                    Text(text = "Today ${sampleData.createdDate}",
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Normal,
                        color = Color.Black,

                        )


                }

            }
            Image(painter = painterResource(
                if (index % 2 == 0){
                    R.drawable.ic_calles

                }else R.drawable.ic_videocall),
                contentDescription ="Income & Outgoing calls icon ",
                modifier = Modifier
                    .width(30.dp)
                    .height(30.dp)
                    .padding(0.dp, 0.dp, 3.dp, 0.dp)
            )

        }

    }

}
