package ru.alexpan.expandabletextview.example

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import ru.alexpan.example.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tv_eee.text = "sdfsdfsdfsdfsdfsdjhsdbf,jhsdbflsdjkfbsdl;jkfbnsdk;fjnsdfjkbsd.kjsbjksdbfsdjkfbsdjkfbsdjkfbsjkfbsdkjf" +
                "fgdfgdfgdfgsdfgsdfgsdfgsdfgdfgsgsdfgdfgljkdfnglkdfjngdfk;jsgn;kjdfgn;skldfjgn'sdfkgsd" +
                "sdfgsdfgsdfg.kjdsfng;sdfkljng;sljkng'kngk'gmfmgl;df sdfgsdfgsdfg.kjdsfng;sdfkljng;sljkng'kngk'gmfmgl;df" +
                "sdfgsdfgsdfg.kjdsfng;sdfkljng;sljkng'kngk'gmfmgl;df" +
                "sdfgsdfgsdfg.kjdsfng;sdfkljng;sljkng'kngk'gmfmgl;df" +
                "sdfgsdfgsdfg.kjdsfng;sdfkljng;sljkng'kngk'gmfmgl;df"
        tv_eee.setTrimLength(200)
    }
}
