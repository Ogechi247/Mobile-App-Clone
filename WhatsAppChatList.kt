package com.example.whatsappclone.view

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.whatsappclone.R
import com.example.whatsappclone.model.SampleData
import com.example.whatsappclone.ui.theme.Whatsappthemecolor
import com.example.whatsappclone.ui.theme.chatbackground
import com.example.whatsappclone.ui.theme.textbackground
import com.example.whatsappclone.viewmodel.WhatsAppChatViewModel
import java.text.SimpleDateFormat
import java.util.Date


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WhatsAppChatList(navController: NavHostController) {
    val menuExpanded = remember { mutableStateOf( false) }
    val viewModel : WhatsAppChatViewModel = viewModel()
    val getAllChat = viewModel.getsampledata.observeAsState(mutableListOf())
    val flag = viewModel.flag.observeAsState()

    val topBar: @Composable () -> Unit = {
        TopAppBar(title = {
            Row(
                modifier = Modifier
                    .padding(top = 16.dp)
                    .fillMaxWidth()
                    .height(90.dp),
                verticalAlignment = Alignment.CenterVertically


            ) {
                Icon(
                    modifier = Modifier.padding(top = 10.dp),
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "Back Arrow",
                    tint = Color.White
                )
                Image(painter = painterResource(id = R.drawable.ic_white_usercircle ),
                    contentDescription = "User Image",
                    modifier = Modifier
                        .padding(top = 10.dp)
                        .height(60.dp)
                        .width(60.dp)


                )
                Column(
                    verticalArrangement = Arrangement.Center,

                    ) {
                    Text(

                        modifier = Modifier.padding(top = 12.dp),
                        text = "07016913740" ,
                        color = Color.White,
                        fontSize = 17.sp
                    )

                }

            }



        },
            actions = {
                IconButton(onClick = { },modifier = Modifier.padding(top = 24.dp)) {
                    Icon(

                        painter = painterResource(id = R.drawable.ic_videocall),
                        contentDescription = "",
                        tint = Color.White


                    )
                }
                IconButton(onClick = { },modifier = Modifier.padding(top = 23.dp)) {
                    Icon(

                        painter = painterResource(id = R.drawable.ic_calles),
                        contentDescription = "",
                        tint = Color.White


                    )

                }
                IconButton(onClick = { menuExpanded.value = true },modifier = Modifier.padding(top = 23.dp)) {

                    Icon(
                        Icons.Filled.MoreVert,
                        contentDescription = "",
                        tint = Color.White


                    )
                }
                Column(
                    modifier = Modifier.wrapContentSize(Alignment.TopStart)


                ) {
                    DropdownMenu(
                        expanded = menuExpanded.value,
                        onDismissRequest = {menuExpanded.value = false  },
                        modifier = Modifier
                            .width(200.dp)
                            .wrapContentSize(Alignment.TopStart)
                    ) {
                        DropdownMenuItem(onClick = { }) {
                            Text(
                                text = "Add to contacts " )

                        }
                        DropdownMenuItem(onClick = { }) {
                            Text(
                                text = "Report" )

                        }
                        DropdownMenuItem(onClick = { }) {
                            Text(
                                text = "Block" )

                        }
                        DropdownMenuItem(onClick = { }) {
                            Text(
                                text = "Search" )

                        }
                        DropdownMenuItem(onClick = { }) {
                            Text(
                                text = "Mute notifications" )

                        }
                        DropdownMenuItem(onClick = { }) {
                            Text(
                                text = "Wallpaper" )

                        }
                        DropdownMenuItem(onClick = { }) {
                            Text(
                                text = "More" )

                        }


                    }


                }

            },
            //modifier = Modifier.padding(top = 56.06.dp)
            //.fillMaxWidth()
            // .height(56.06.dp),

            backgroundColor = Whatsappthemecolor,
            elevation = AppBarDefaults.TopAppBarElevation





        )

    }
    Scaffold(
       modifier = Modifier.fillMaxSize()
           .background(chatbackground),

        topBar = {
            topBar()
        },
        content ={paddingValues ->
           // Column(modifier = Modifier.padding(top = 30.06.dp)){}
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    //.background(WhatsAppChatBg)
                    .background(chatbackground)
                    .padding(paddingValues)
                    .padding(top = 5.dp),
                horizontalAlignment = Alignment.CenterHorizontally


            ) {
               Text(text = "Today ${flag.value}")
                Spacer(modifier = Modifier.padding(5
                    .dp))

                CallChatList(getAllChat.value)




            }
        },
        bottomBar = {
            BottomDesign(viewModel)
        }

    )
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "UnusedMaterialScaffoldPaddingParameter")
@Composable
fun CallChatList(value: List<SampleData>) {
    val scaffoldState = rememberScaffoldState()
    Surface (

    ){
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            scaffoldState =  scaffoldState
        ){
            CallChatItem(value)

        }
    }


}

@Composable
fun CallChatItem(value: List<SampleData>) {
    LazyColumn(
        modifier = Modifier.fillMaxSize()
            .background(chatbackground)

    ) {
        items(
            value.size
        ){index->
            ChatListItem(data = value[index], index = index)

        }

    }


}


@Composable
fun BottomDesign(viewModel: WhatsAppChatViewModel) {

    val textState = remember{ mutableStateOf(TextFieldValue()) }
    //  val scope = rememberCoroutineScope()
    val date = SimpleDateFormat("hh:mm a")
    val strDate : String = date.format(Date())

    Row(
        modifier = Modifier
            //.padding(5.dp)
            .padding(bottom = 50.dp)
          //  .background(chatbackground)
        ,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(5.dp)

    ){
        Row (//done
            modifier = Modifier
                .weight(0.85f)
                .wrapContentSize()
                .clip(RoundedCornerShape(30.dp))
               .background(Color.White)
                .padding(10.dp, 0.dp, 10.dp, 0.dp)
                    ,
            verticalAlignment = Alignment.CenterVertically)

        {
            Icon(
                painter = painterResource(id = R.drawable.ic_emoji) ,
                contentDescription = "Emoji",
                tint = Color.Gray,
                modifier = Modifier
                    .weight(0.1f)

            )
            TextField(

                value = textState.value,
                onValueChange = { textState.value = it },
                placeholder = {
                    Text(
                        text = "Message",
                        color = Color.Gray,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Normal
                    )

                },

                modifier = Modifier
                    .weight(0.66f)
                    .wrapContentSize(),
                keyboardOptions = KeyboardOptions(
                    capitalization = KeyboardCapitalization.None,
                    keyboardType = KeyboardType.Text,
                    autoCorrect = true,
                    imeAction = ImeAction.Done,

                    ),
                textStyle = TextStyle(color = Color.Black,
                    fontSize = 16.sp
                ),
                maxLines = 70,
                singleLine = false,
                colors = TextFieldDefaults.textFieldColors(
                    textColor = Color.Black,
                      disabledTextColor = Color.Transparent,
                    focusedIndicatorColor =  Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent,

                    )




            )
            Icon(
                painter = painterResource(id = R.drawable.ic_clipattach ) ,
                contentDescription = "Attach",
                tint = Color.Gray,
                modifier = Modifier.weight(0.14f)
            )
            Icon(
                painter = painterResource(id = R.drawable.ic_camera) ,
                contentDescription = "Attach Picture",
                tint = Color.Gray,
                modifier = Modifier.weight(0.1f)
            )


        }
        Row(
            modifier = Modifier.weight(0.15f),
            horizontalArrangement = Arrangement.Center
        ){
            FloatingActionButton(
                onClick = {
                    if(textState.value.text.isNotEmpty()){
                        val sampleData = SampleData(
                            "Name",
                            textState.value.text,
                            "sample Url",
                            strDate
                        )
                        viewModel.addChat(sampleData)

                    }
                },
                backgroundColor = Whatsappthemecolor
            )
            {
                Icon(
                    painter = painterResource(
                        if(textState.value.text.isEmpty()){
                            R.drawable.ic_textrecord
                        } else{
                            R.drawable.ic_send
                        }
                    ),
                    contentDescription = "Text Icon",
                    tint = Color.White,
                    modifier = Modifier.padding(10.dp)

                )
            }

        }

    }
}


@Composable
fun ChatListItem(data: SampleData, index :Int) {

    Column(
        modifier = Modifier.fillMaxWidth()
           .background(chatbackground)
    ) {
        if (index % 2 == 0) {
            Column(
                modifier = Modifier
                    .fillMaxWidth(0.4f)
                    .clip(RoundedCornerShape(10.dp))
                    //.background(WhatsAppOutgoingMsg)
                    .background(textbackground)
                    .padding(5.dp)

            ) {
                Text(text =data.des,
                    color = Color.Black,
                    fontSize = 16.sp

                )

                Text(
                    text = data.createdDate,
                    color = Color.LightGray,
                    fontSize = 12.sp,
                    textAlign = TextAlign.End,
                    modifier = Modifier.fillMaxWidth()

                )

            }

        } else {
            Column(
                modifier = Modifier
                    .fillMaxWidth(0.4f)
                    .clip(RoundedCornerShape(10.dp))
                    //.background(WhatsAppOutgoingMsg)
                    .background(textbackground)
                    .padding(5.dp)
                    .align(Alignment.End)

            ) {
                Text(text =data.des,
                    color = Color.Black,
                    fontSize = 16.sp

                )

                Text(
                    text = data.createdDate,
                    color = Color.LightGray,
                    fontSize = 12.sp,
                    textAlign = TextAlign.End,
                    modifier = Modifier.fillMaxWidth()

                )

            }
        }


    }
}
