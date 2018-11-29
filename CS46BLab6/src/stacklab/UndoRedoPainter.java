package stacklab;

import java.util.*;


public class UndoRedoPainter extends Painter
{
	// Called when the user pushes the Undo button.
	void undo()
	{
		super.setRedoButtonEnabled(true);
		Stack<Circle> history = super.getHistory();
		
		Stack<Circle> undoHistory = super.getUndoHistory();
		undoHistory.push(history.pop());
		if(history.isEmpty()) {
			super.setUndoButtonEnabled(false);
		}
		super.repaint();
		
	}


	// Called when the user pushes the Redo button.
	void redo(){
		Stack<Circle> undoHistory = super.getUndoHistory();
		Stack<Circle> history = super.getHistory();
		history.push(undoHistory.pop());
		if(undoHistory.isEmpty()) {
			super.setRedoButtonEnabled(false);
		}
		super.repaint();
	}
	
	
	public static void main(String[] args)
	{
		new UndoRedoPainter().setVisible(true);
	}
	
	public UndoRedoPainter() {
		super.setUndoButtonEnabled(false);
		super.setRedoButtonEnabled(false);
	}
}
