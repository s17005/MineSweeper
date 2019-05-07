package jp.ac.it_college.std.s17007.minesweeper

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Point
import android.util.DisplayMetrics
import android.view.View
import android.widget.Button
import android.widget.TextView
import jp.ac.it_college.std.s17007.minesweeper.R.id.field
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*


class MainActivity : AppCompatActivity() {
    val ROW = 9
    val COLUMN = 9
    val MINE_COUNT = 10

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        createView()

    }

    private fun createView(){
        setContentView(R.layout.activity_main)
        generateField()
        val button = findViewById<Button>(R.id.resetTextView)

        button.setOnClickListener{
            createView()
        }
    }

    private fun generateField(){
        //0:kihon 1~8:num of near mine 9:mine
        var mineField = Array(COLUMN,{ arrayOfNulls<String>(ROW) })
        var i = 0
        var j = 0
        for(i in 0..8){
            for(j in 0..8){
                mineField[i][j] = " "
            }
        }
        val rand = Random()
        var count = 0
        while(count < MINE_COUNT){
            var x = rand.nextInt(9)
            var y = rand.nextInt(9)

            if(mineField[x][y] != "*"){
                mineField[x][y] = "*"
                count++
            }
        }


        var counter = 0
        for(i in 0..8){
            for(j in 0..8){
                if(i == 0){
                    if(j == 0){
                        if(mineField[i][j] != "*"){
                            if (mineField[i + 1][j].equals("*")) {
                                counter++
                            }
                            if (mineField[i][j + 1].equals("*")) {
                                counter++
                            }
                            if (mineField[i + 1][j + 1].equals("*")) {
                                counter++
                            }
                            if (counter >= 1) {
                                mineField[i][j] = counter.toString()
                            }
                        }

                    }
                    else if(j == 8){
                        if(mineField[i][j] != "*") {
                            if (mineField[i][j - 1].equals("*")) {
                                counter++
                            }
                            if (mineField[i + 1][j - 1].equals("*")) {
                                counter++
                            }
                            if (mineField[i + 1][j].equals("*")) {
                                counter++
                            }
                            if (counter >= 1) {
                                mineField[i][j] = counter.toString()
                            }
                        }
                    }
                    else{
                        if(mineField[i][j] != "*") {
                            if (mineField[i][j - 1].equals("*")) {
                                counter++
                            }
                            if (mineField[i + 1][j - 1].equals("*")) {
                                counter++
                            }
                            if (mineField[i + 1][j].equals("*")) {
                                counter++
                            }
                            if (mineField[i + 1][j + 1].equals("*")) {
                                counter++
                            }
                            if (mineField[i][j + 1].equals("*")) {
                                counter++
                            }
                            if (counter >= 1) {
                                mineField[i][j] = counter.toString()
                            }
                        }
                    }
                }
                else if(i == 8){
                    if(j == 0){
                        if(mineField[i][j] != "*") {
                            if (mineField[i - 1][j].equals("*")) {
                                counter++
                            }
                            if (mineField[i - 1][j + 1].equals("*")) {
                                counter++
                            }
                            if (mineField[i][j + 1].equals("*")) {
                                counter++
                            }
                            if (counter >= 1) {
                                mineField[i][j] = counter.toString()
                            }
                        }
                    }
                    else if(j == 8){
                        if(mineField[i][j] != "*"){
                            if(mineField[i][j-1].equals("*")){
                                counter++
                            }
                            if(mineField[i-1][j-1].equals("*")){
                                counter++
                            }
                            if(mineField[i-1][j].equals("*")){
                                counter++
                            }
                            if(counter >= 1){
                                mineField[i][j] = counter.toString()
                            }
                        }
                    }
                    else{
                        if(mineField[i][j] != "*"){
                            if(mineField[i][j-1].equals("*")){
                                counter++
                            }
                            if(mineField[i-1][j-1].equals("*")){
                                counter++
                            }
                            if(mineField[i-1][j].equals("*")){
                                counter++
                            }
                            if(mineField[i-1][j+1].equals("*")){
                                counter++
                            }
                            if(mineField[i][j+1].equals("*")){
                                counter++
                            }
                            if(counter >= 1){
                                mineField[i][j] = counter.toString()
                            }
                        }
                    }
                }
                else{
                    if(j == 0){
                        if(mineField[i][j] != "*"){
                            if(mineField[i-1][j].equals("*")){
                                counter++
                            }
                            if(mineField[i-1][j+1].equals("*")){
                                counter++
                            }
                            if(mineField[i][j+1].equals("*")){
                                counter++
                            }
                            if(mineField[i+1][j+1].equals("*")){
                                counter++
                            }
                            if(mineField[i+1][j].equals("*")){
                                counter++
                            }
                            if(counter >= 1){
                                mineField[i][j] = counter.toString()
                            }
                        }
                    }
                    else if(j == 8){
                        if(mineField[i][j] != "*"){
                            if(mineField[i-1][j].equals("*")){
                                counter++
                            }
                            if(mineField[i-1][j-1].equals("*")){
                                counter++
                            }
                            if(mineField[i][j-1].equals("*")){
                                counter++
                            }
                            if(mineField[i+1][j-1].equals("*")){
                                counter++
                            }
                            if(mineField[i+1][j].equals("*")){
                                counter++
                            }
                            if(counter >= 1){
                                mineField[i][j] = counter.toString()
                            }
                        }
                    }
                    else{
                        if(mineField[i][j] != "*"){
                            if(mineField[i-1][j-1].equals("*")){
                                counter++
                            }
                            if(mineField[i-1][j].equals("*")){
                                counter++
                            }
                            if(mineField[i-1][j+1].equals("*")){
                                counter++
                            }
                            if(mineField[i][j-1].equals("*")){
                                counter++
                            }
                            if(mineField[i][j+1].equals("*")){
                                counter++
                            }
                            if(mineField[i+1][j-1].equals("*")){
                                counter++
                            }
                            if(mineField[i+1][j].equals("*")){
                                counter++
                            }
                            if(mineField[i+1][j+1].equals("*")){
                                counter++
                            }
                            if(counter >= 1){
                                mineField[i][j] = counter.toString()
                            }
                        }
                    }
                }
                counter = 0
            }
        }


        var id = 0
        var idString = "textview"
        for(i in 0..8){
            for(j in 0..8){
                idString += id.toString()
                val callid = resources.getIdentifier(idString,"id",packageName)
                val cell = findViewById<TextView>(callid)
                cell.setText(mineField[i][j].toString())
                idString = "textview"
                id++
            }
        }

    }
    
}


