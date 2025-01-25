package com.example.whatsappclone

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.pager.HorizontalPager

import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.Icon

import androidx.compose.runtime.remember

import androidx.compose.ui.unit.dp
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.ui.Alignment
import androidx.compose.runtime.rememberCoroutineScope
import kotlinx.coroutines.launch
//import androidx.compose.material.TabRowDefaults
//import androidx.compose.foundation.pager.PagerState
import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material.IconButton
import androidx.compose.material3.Scaffold
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import com.example.whatsappclone.ui.theme.WhatsappCloneTheme
import androidx.compose.material.icons.filled.Search
import android.widget.Toast // Import Toast
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.AppBarDefaults
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.TabRowDefaults
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.example.whatsappclone.ui.theme.Whatsappthemecolor
//import com.google.accompanist.pager.ExperimentalPagerApi
//import com.google.accompanist.pager.HorizontalPagerIndicator
//import com.google.accompanist.pager.PagerState
//import com.google.accompanist.pager.pagerTabIndicatorOffset
import androidx.compose.foundation.pager.PagerState
import androidx.compose.material.DropdownMenuItem
//import androidx.compose.material.FloatingActionButtonDefaults
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.FloatingActionButton
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.whatsappclone.ui.theme.liteColor
import com.example.whatsappclone.utils.Constants._tabCurrentStatus
import com.example.whatsappclone.utils.Constants.tabCurrentStatus
import com.example.whatsappclone.view.CallsScreen
import com.example.whatsappclone.view.ChatsScreen
import com.example.whatsappclone.view.StatusScreen
import com.example.whatsappclone.view.WhatsAppChatList


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WhatsappCloneTheme {
                    val navController = rememberNavController()
                NavHost(navController = navController, startDestination ="whats_app_main" )
                {
                    composable("whats_app_main"){Whatsapp(navController)}
                    composable("whats_app_chats"){WhatsAppChatList(navController)}

                }

                }
            }
        }
    }



@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Whatsapp(navController: NavHostController) {
    val context = LocalContext.current
    val menuExpanded = remember { mutableStateOf(false) }
    val tabStatus = tabCurrentStatus.observeAsState()
    val topBar: @Composable () -> Unit = {
        TopAppBar(

            title = {
                Text(
                  modifier = Modifier.padding(top = 37.dp),

                    text = "Chatter",
                    color = Color.White,
                    fontSize = 20.sp
                )

            },
            actions = {
                IconButton(
                    modifier = Modifier.padding(top = 37.dp),
                    onClick = {
                        Toast.makeText(context, "Search clicked!", Toast.LENGTH_SHORT).show()


                    }
                ) {
                    Icon(

                        Icons.Filled.Search,
                        contentDescription = "search",
                        tint = Color.White

                    )
                }



                IconButton(
                    modifier = Modifier.padding(top = 37.dp),
                    onClick = {
                        Toast.makeText(context, "Camera clicked!", Toast.LENGTH_SHORT).show()


                    }
                ) {
                    Icon(

                        painter = painterResource(id = R.drawable.ic_camera,),
                        contentDescription = "Camera",
                        tint = Color.White

                    )
                }


                IconButton(
                    modifier = Modifier.padding(top = 37.dp),
                    onClick = {
                        menuExpanded.value = true

                    }
                ) {
                    Icon(

                        Icons.Filled.MoreVert,
                        contentDescription = "Menu",
                        tint = liteColor
                    )
                }
                Column(
                    modifier = Modifier
                        .wrapContentSize(Alignment.TopStart),

                ) {
                    DropdownMenu(
                        modifier = Modifier
                            .width(200.dp)
                            .wrapContentSize(Alignment.TopStart),
                        expanded = menuExpanded.value,


                        onDismissRequest = {
                            menuExpanded.value = false
                        },
                        ) {
                        when(tabStatus.value){
                            0-> {
                                DropdownMenuItem(onClick = {/*handle New Group*/ }) {
                                    Text(text = "New Group")
                                }
                                DropdownMenuItem(onClick = {/*handle broadcast*/ }) {
                                    Text(text = "New Broadcast")
                                }
                                DropdownMenuItem(onClick = {/*handle devices*/ }) {
                                    Text(text = "Linked devices")
                                }
                                DropdownMenuItem(onClick = {/*handle messages */ }) {
                                    Text(text = "Starred messages")
                                }
                                DropdownMenuItem(onClick = {/*handle Settings*/ }) {
                                    Text(text = "Settings")
                                }
                            }
                            1-> {
                                DropdownMenuItem(onClick = {/*handle Channels */ }) {
                                    Text(text = "Create channel")
                                }
                                DropdownMenuItem(onClick = {/*handle Status*/ }) {
                                    Text(text = "Status privacy")
                                }
                                DropdownMenuItem(onClick = {/*handle Settings*/ }) {
                                    Text(text = "Settings")
                                }

                            }
                            2-> {
                                DropdownMenuItem(onClick = {/*handle messages */ }) {
                                    Text(text = "Clear call logs ")
                                }
                                DropdownMenuItem(onClick = {/*handle Settings*/ }) {
                                    Text(text = "Settings")
                                }


                            }




                        }
                    }

                }

            },
            backgroundColor = Whatsappthemecolor,
            elevation = AppBarDefaults.TopAppBarElevation,
        )
    }
    Scaffold(


        topBar = {
            topBar()

        },
        content = {
            Column(modifier = Modifier.padding(top = 56.06.dp)) {
            WhatsappTab(navController)

        }
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    Toast.makeText(context, "Button Clicked", Toast.LENGTH_SHORT ).show()

                 },
                containerColor = Whatsappthemecolor,
                elevation = FloatingActionButtonDefaults.elevation(),
                modifier = Modifier.padding(10.dp)




            ) {
                when(tabStatus.value){
                    0->{
                       Icon( painterResource(id =R.drawable.ic_chat ),
                           contentDescription = "Message" ,
                           tint = if(isSystemInDarkTheme())Color.Black else Color.White,
                           modifier = Modifier.padding(10.dp)
                       )
                    }
                    1->{
                        Icon( painterResource(id =R.drawable.ic_statuscamera ),
                            contentDescription = "Camera" ,
                            tint = if(isSystemInDarkTheme())Color.Black else Color.White,
                            modifier = Modifier.padding(10.dp)
                        )


                    }
                    2->{Icon( painterResource(id =R.drawable.ic_calls ),
                        contentDescription = "Add Call" ,
                        tint = if(isSystemInDarkTheme())Color.Black else Color.White,
                        modifier = Modifier.padding(10.dp)
                    )}
                }

            }
        }
    )
}



@Composable
fun  WhatsappTab(navController: NavHostController) {
    val list = listOf("CHATS","STORIES","CALLS")

    val pagerState = rememberPagerState { list.size }

    Column(

    ) {
        Tabs(pagerState)
        TabsContent(pagerState,navController)

    }

}



@Composable
fun Tabs(pagerState: PagerState) {
    val list = listOf("CHATS","STORIES","CALLS")
    val scope = rememberCoroutineScope()
    _tabCurrentStatus.value = pagerState.currentPage
    TabRow(
        selectedTabIndex = pagerState.currentPage,
        backgroundColor = Whatsappthemecolor,

        contentColor =  Color.White,
        indicator = { tabPositions ->
            TabRowDefaults.Indicator(
                modifier = Modifier.tabIndicatorOffset(tabPositions[pagerState.currentPage]),
                height = 2.dp,
                color = Color.White

            )

        }

    ) {
        list.forEachIndexed{index, tabs ->
            Tab(
                text = {
                    Text(
                        list.get(index),
                        color = Color.White,
                        fontSize = 12.sp

                    )
                },
                selected = pagerState.currentPage == index,
                onClick = {
                    scope.launch {
                        pagerState.animateScrollToPage(index)

                    }
                }
            )

        }

    }

}


@OptIn(ExperimentalFoundationApi::class)

@Composable
fun TabsContent(pagerState: PagerState, navController: NavHostController,) {
    HorizontalPager(state = pagerState,modifier = Modifier.fillMaxSize(),) { page ->
        when (page) {
            0 -> ChatsScreen(navController)
            1 -> StatusScreen()
            2 -> CallsScreen()

        }
    }
}
