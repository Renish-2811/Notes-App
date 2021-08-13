package com.example.inotes

import android.app.PendingIntent.getActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), Iclick {
    lateinit var viewModel: WordViewModel

    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rview.layoutManager = LinearLayoutManager(this)
       rview.addItemDecoration(
            DividerItemDecoration(
               this,
                DividerItemDecoration.VERTICAL
            )
        )
        val adap = CustomAdapter(this, this)
        rview.adapter = adap

        viewModel = ViewModelProvider(
            this, ViewModelProvider.AndroidViewModelFactory.getInstance(
                application
            )
        ).get(WordViewModel::class.java)
        viewModel.allWords.observe(this, Observer { list ->
            list?.let { adap.updatelist(it) }

        })

    }

    override fun Onitemclick(note: Notes) {
      viewModel.deletenode(note)
        val text = "Deleted"
        val duration = Toast.LENGTH_SHORT

        val toast = Toast.makeText(applicationContext, text, duration)
        toast.show()
        editTextTextPersonName.setText("")
    }

    fun insrtnote(view: View) {
        val ntext = editTextTextPersonName.text.toString()
        if (ntext.isNotEmpty())
        {
            viewModel.insert(Notes(ntext))
        }
        val text = "Inserted"
        val duration = Toast.LENGTH_SHORT

        val toast = Toast.makeText(applicationContext, text, duration)
        toast.show()
editTextTextPersonName.setText("")
    }
}