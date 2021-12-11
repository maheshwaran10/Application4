package com.example.company.recycler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.company.R
import com.example.company.databinding.ActivityMain2Binding


class MainActivity2 : AppCompatActivity() {
    private lateinit var mBinding: ActivityMain2Binding

    private val conditionalHeaderAdapter by lazy { ConditionalHeaderAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        supportActionBar?.hide()

        mBinding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(mBinding.root)

        mBinding.rvUsers.layoutManager = LinearLayoutManager(applicationContext)
        mBinding.rvUsers.adapter = conditionalHeaderAdapter

        conditionalHeaderAdapter.setData(getDummyData())
    }

    private fun getDummyData(): ArrayList<Any> {
        val dummyList = ArrayList<Any>()


        dummyList.add(16)
        dummyList.add("random street, 23 area mylapore")
        dummyList.add("random street, 23 area mylapore")
        dummyList.add(17)
        dummyList.add("random street, 23 area mylapore")
        dummyList.add(18)
        dummyList.add("random street, 23 area mylapore")
        dummyList.add("random street, 23 area mylapore")
        dummyList.add("random street, 23 area mylapore")

        return dummyList
    }
}
