package edu.tcu.tanmaykejriwal.paint
import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.get
import androidx.core.view.iterator
import edu.tcu.tanmaykejriwal.paint.DrawingView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var pallet = findViewById<LinearLayout>(R.id.pallete_ll)
        var board = findViewById<DrawingView>(R.id.board)
        var undo = findViewById<ImageView>(R.id.undo)
        var selected=pallet[0]
        for(iv in pallet){
            iv.setOnClickListener {
                board.SetPathColor((iv.background as ColorDrawable).color)
                (iv as ImageView).setImageResource(R.drawable.path_color_selected)
                (selected as ImageView).setImageResource(R.drawable.path_color_normal)
                selected=iv
            }
        }

        undo.setOnClickListener{
            board.undoPath()
        }



        findViewById<ImageView>(R.id.brush).setOnClickListener {
            val dialog = Dialog(this)
            dialog.setContentView(R.layout.path_width_selector)
            dialog.show()
            dialog.findViewById<ImageView>(R.id.small_width_iv).setOnClickListener {
                board.SetPathWidth(5*resources.displayMetrics.density)
                dialog.dismiss()
            }

            dialog.findViewById<ImageView>(R.id.medium_width_iv).setOnClickListener {
                board.SetPathWidth(10*resources.displayMetrics.density)
                dialog.dismiss()
            }

            dialog.findViewById<ImageView>(R.id.large_width_iv).setOnClickListener {
                board.SetPathWidth(15*resources.displayMetrics.density)
                dialog.dismiss()
            }


        }


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