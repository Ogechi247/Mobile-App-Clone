package com.example.whatsappclone.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.whatsappclone.model.SampleData
import java.text.SimpleDateFormat
import java.util.Date

class WhatsAppChatViewModel: ViewModel() {
   private val date = SimpleDateFormat("hh:mm a")
     private val strDate : String = date.format(Date())
    val getsampledata: LiveData<List<SampleData>> get() = _getSampledata
    private val _getSampledata = MutableLiveData<List<SampleData>>()


    private val _flag = MutableLiveData(false)
    val flag: LiveData<Boolean> get() = _flag



     private val chatlistitem = mutableListOf(
        SampleData(name = "Diego",des = "Hi Welcome ",imgirl = "sampleirl",strDate),
        SampleData(name = "Ik bro ",des = "wassup",imgirl = "sampleirl",strDate),
        SampleData(name = "Umeh",des = " Hello oge ", imgirl = "sampleirl",strDate),
        SampleData(name = " Chinaza ",des = "sup gee",imgirl = "sampleirl",strDate),
        SampleData(name = "Oge",des = " presido ",imgirl = "sampleirl",strDate),
        SampleData(name = "Andriod presido",des = "take it easy 1",imgirl = "sampleirl",strDate),


    )
    init {
        _getSampledata.value = chatlistitem

    }
    fun addChat(data: SampleData){
        _flag.value = _flag.value !=true
        chatlistitem.addAll(listOf(data))
        _getSampledata.value = chatlistitem
    }

}
