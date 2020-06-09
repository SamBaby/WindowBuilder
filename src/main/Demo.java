package main;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Group;

public class Demo {
	public int labelNum1 = 0;
	protected Shell shell;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Demo window = new Demo();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("SWT Application");
		/******************************/
		
		Composite labelComposite = new Composite(shell, SWT.NONE);
		labelComposite.setBounds(10, 23, 148, 51);
		labelComposite.setVisible(false);
		Label lblNewLabel = new Label(labelComposite, SWT.NONE);
		lblNewLabel.setBounds(0, 0, 58, 17);
		lblNewLabel.setText("Label");
		/******************************/
		Button oldButton = new Button(labelComposite, SWT.NONE);
		oldButton.setBounds(0, 23, 71, 28);
		oldButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				lblNewLabel.setText("Old Label");
			}
		});
		oldButton.setText("Old Button");
		/******************************/
		Button minusButton = new Button(labelComposite, SWT.NONE);
		minusButton.setBounds(77, 23, 71, 28);
		minusButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				lblNewLabel.setText("New Label");
			}
		});
		minusButton.setText("New Button");
		/******************************/
		
		Composite calComposite = new Composite(shell, SWT.NONE);
		calComposite.setBounds(10, 88, 148, 59);
		calComposite.setVisible(false);
		Label numLabel = new Label(calComposite, SWT.NONE);
		numLabel.setBounds(0, 0, 58, 17);
		numLabel.setText(Integer.toString(labelNum1));
		/******************************/
		Button btnNewButton = new Button(calComposite, SWT.NONE);
		btnNewButton.setBounds(0, 31, 71, 28);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				labelNum1++;
				numLabel.setText(Integer.toString(labelNum1));
			}
		});
		btnNewButton.setText("add");
		/******************************/
		Button btnNewButton_1 = new Button(calComposite, SWT.NONE);
		btnNewButton_1.setBounds(77, 31, 71, 28);
		btnNewButton_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				labelNum1--;
				numLabel.setText(Integer.toString(labelNum1));
			}
		});
		btnNewButton_1.setText("subtract");
		
		Menu menu = new Menu(shell, SWT.BAR);
		shell.setMenuBar(menu);
		
		MenuItem lableItem = new MenuItem(menu, SWT.NONE);
		lableItem.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(labelComposite.isVisible())
					labelComposite.setVisible(false);
				else
					labelComposite.setVisible(true);
			}
		});
		lableItem.setText("Label");
		
		MenuItem calItem = new MenuItem(menu, SWT.NONE);
		calItem.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(calComposite.isVisible())
					calComposite.setVisible(false);
				else
					calComposite.setVisible(true);
			}
		});
		calItem.setText("Calculater");
	

	}
}
