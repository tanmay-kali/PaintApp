package edu.tcu.tanmaykejriwal.paint

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.widget.Button
import android.widget.Toast

class DrawingView(context: Context, attrs:AttributeSet) : View(context,attrs){
    private val paint = Paint()
    private val pathList = mutableListOf<CustomPath>()
    private var path = CustomPath(Color.BLACK,10 * resources.displayMetrics.density);


    init {
        paint.style = Paint.Style.STROKE;
        paint.strokeCap = Paint.Cap.ROUND;
        paint.strokeJoin = Paint.Join.ROUND;

    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onTouchEvent(event: MotionEvent): Boolean {
        val x = event.x;
        val y = event.y;

        return when(event.action){
            MotionEvent.ACTION_DOWN ->{
                pathList.add(path)
                path.moveTo(x,y)
                true
            }
            MotionEvent.ACTION_MOVE ->{
                path.lineTo(x,y)
                invalidate() // calling on Draw
                true
            }
            MotionEvent.ACTION_UP->{
                path = CustomPath(path.color,path.width)
                true
            }
            else->false
        }
    }

    override fun onDraw(canvas: Canvas) {
        for(path in pathList){
            paint.color = path.color;
            paint.strokeWidth = path.width;
            canvas.drawPath(path,paint);


        }
    }


    fun SetPathColor(Color:Int){
        path = CustomPath(Color,path.width)
    }

     fun SetPathWidth(Width:Float){
         path = CustomPath(path.color,Width)
    }

    fun getPathWidth():Float{
        return path.width
    }

    fun undoPath(){
        if(pathList.size>0){
            pathList.removeLast()
            invalidate()
        }
        else{
            Toast.makeText(context,"Nothing to Undo", Toast.LENGTH_SHORT).show()
        }

    }
}

private data class CustomPath(val color:Int,val width :Float) : Path()

