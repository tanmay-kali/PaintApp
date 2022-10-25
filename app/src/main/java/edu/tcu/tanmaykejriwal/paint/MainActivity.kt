package edu.tcu.tanmaykejriwal.paint
import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import edu.tcu.tanmaykejriwal.paint.DrawingView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btnColor = findViewById<Button>(R.id.color)
        var btnBlack = findViewById<Button>(R.id.black)
        var btnSize = findViewById<Button>(R.id.size)
        var btnSizeRed = findViewById<Button>(R.id.sizesub)
        var btnUndo = findViewById<Button>(R.id.undo)
        var board = findViewById<DrawingView>(R.id.board)

        btnColor.setOnClickListener{
            board.SetPathColor(Color.parseColor("#0096FF"))
        }
        btnBlack.setOnClickListener {
            board.SetPathColor(Color.BLACK)
        }

        btnSize.setOnClickListener{
            board.SetPathWidth(board.getPathWidth()*2)
        }

        btnSizeRed.setOnClickListener {
            board.SetPathWidth(board.getPathWidth()/2)
        }

        btnUndo.setOnClickListener{
            board.undoPath()
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