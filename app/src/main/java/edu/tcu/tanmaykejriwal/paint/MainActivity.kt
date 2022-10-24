package edu.tcu.tanmaykejriwal.paint

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}


//Notes
/*
* Paint : Store Style(including width) and color
* Path: Store the footprint
* Custom Path(color,width) : Path
* pathList -> Mutable List of <CustomPath>()
* color change or width change -> CustomPath(path.color,path.width)
*
* Hw for Tuesday 25 OCT
* Create Method SetPathColor(Color:Int)
* Create Method SetPathWidth(width:Int) dp -> gives float
* Create Undo - > remove last form pathList and the Invalidate -> undoPath()
* 3 buttons for undo,width and one color
*
* */