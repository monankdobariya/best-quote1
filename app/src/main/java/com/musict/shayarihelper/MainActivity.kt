package com.musict.shayarihelper

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.PopupMenu
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.musict.shayarihelper.Adapter.CategoryAdapter
import com.musict.shayarihelper.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var mainBinding: ActivityMainBinding

    lateinit var adapter: CategoryAdapter

    var categorylist = ArrayList<CategoryModel>()
    lateinit var db: MyDatabase


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.statusBarColor = ContextCompat.getColor(this, R.color.batali)
        }
        db = MyDatabase(this)
        initview()

    }

    private fun initview() {

        categorylist = db.categoryData()

        adapter = CategoryAdapter(categorylist) {
            var i = Intent(this, DisplayCategory::class.java)
            i.putExtra("Title", it.CategoryName)
            i.putExtra("id", it.id)
            startActivity(i)

            Log.e("TAG", "initview: " + it.id)


        }
        var manager = GridLayoutManager(this, 2)
        mainBinding.rcv.layoutManager = manager
        mainBinding.rcv.adapter = adapter



        mainBinding.threedote.setOnClickListener {

            var i = Intent(this, favourit_shayari_collacter::class.java)
            startActivity(i)
        }


    }

}
