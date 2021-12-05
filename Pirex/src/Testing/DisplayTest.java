package Testing;

import java.io.File;
import java.util.ArrayList;

import javax.annotation.processing.Generated;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.event.DocumentEvent;

import org.junit.Test;
import org.junit.tools.configuration.base.MethodRef;

import Data.Doc;
import Display.Display;

@Generated(value = "org.junit-tools-1.1.0")
public class DisplayTest {

	private Display createTestSubject() {
		return new Display();
	}

	@MethodRef(name = "createGUI", signature = "()V")
	@Test
	public void testCreateGUI() throws Exception {
		Display testSubject;

		// default test
		testSubject = createTestSubject();
		testSubject.createGUI();
	}

	@MethodRef(name = "initialize", signature = "()V")
	@Test
	public void testInitialize() throws Exception {
		Display testSubject;

		// default test
		testSubject = createTestSubject();
		testSubject.initialize();
	}

	@MethodRef(name = "processing", signature = "()V")
	@Test
	public void testProcessing() throws Exception {
		Display testSubject;
		
		// default test
		testSubject = createTestSubject();
		testSubject.titleTextField.setText("Test");
		testSubject.authorTextField.setText("Test");
		testSubject.fileTextField.setText("C:\\Users\\Boreal\\OneDrive\\Documents\\PirexDataCopy\\Monty Python.txt");
		testSubject.processing();
		testSubject.docs.get(testSubject.docs.size() - 1);
		DefaultListModel<String> model = new DefaultListModel<String>();
		model.addElement(testSubject.docs.get(testSubject.docs.size() - 1).shortForm("Monty"));
		testSubject.deleteFile();
	}

	@MethodRef(name = "copy", signature = "(QFile;QFile;)V")
	@Test
	public void testCopy() throws Exception {
		File source = null;
		File dest = null;

		// test 1
		source = null;
		dest = null;
		Display.copy(source, dest);

		// test 2
		dest = null;
		source = null;
		Display.copy(source, dest);
	}

	@MethodRef(name = "copyDirectory", signature = "(QFile;QFile;)V")
	@Test
	public void testCopyDirectory() throws Exception {
		Display testSubject;
		File sourceLocation = null;
		File targetLocation = null;

		// test 1
		testSubject = createTestSubject();
		sourceLocation = null;
		targetLocation = null;
		testSubject.copyDirectory(sourceLocation, targetLocation);

		// test 2
		testSubject = createTestSubject();
		targetLocation = null;
		sourceLocation = null;
		testSubject.copyDirectory(sourceLocation, targetLocation);
	}

	@MethodRef(name = "load", signature = "()V")
	@Test
	public void testLoad() throws Exception {
		Display testSubject;

		// default test
		testSubject = createTestSubject();
		testSubject.load();
	}

	@MethodRef(name = "save", signature = "()V")
	@Test
	public void testSave() throws Exception {
		Display testSubject;

		// default test
		testSubject = createTestSubject();
		testSubject.save();
	}

	@MethodRef(name = "summaryText", signature = "(QArrayList<QDoc;>;)QString;")
	@Test
	public void testSummaryText() throws Exception {
		Display testSubject;
		ArrayList<Doc> docs = new ArrayList<Doc>();
		docs.add(new Doc("Monty Python", "", ""));
		String result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.summaryText(docs);
	}

	@MethodRef(name = "loadTimer", signature = "(QArrayList<QString;>;)V")
	@Test
	public void testLoadTimer() throws Exception {
		Display testSubject;
		ArrayList<String> loadInfo = new ArrayList<String>();
		loadInfo.add("");
		loadInfo.add("");
		loadInfo.add("");
		// default test
		testSubject = createTestSubject();
		testSubject.loadTimer(loadInfo);
	}

	@MethodRef(name = "info", signature = "(QArrayList<QString;>;)V")
	@Test
	public void testInfo() throws Exception {
		Display testSubject;
		ArrayList<String> loadInfo = new ArrayList<String>();
		loadInfo.add("");
		loadInfo.add("");
		loadInfo.add("");

		// default test
		testSubject = createTestSubject();
		testSubject.info(loadInfo);
	}

	@MethodRef(name = "addDots", signature = "(I)V")
	@Test
	public void testAddDots() throws Exception {
		Display testSubject;
		int x = 0;

		// default test
		testSubject = createTestSubject();
		testSubject.addDots(x);
	}

	@MethodRef(name = "deleteFile", signature = "()V")
	@Test
	public void testDeleteFile() throws Exception {
		Display testSubject;

		// default test
		testSubject = createTestSubject();
		testSubject.deleteFile();
	}

	@MethodRef(name = "editFile", signature = "()V")
	@Test
	public void testEditFile() throws Exception {
		Display testSubject;

		// default test
		testSubject = createTestSubject();
		testSubject.editFile();
	}

	@MethodRef(name = "search", signature = "()V")
	@Test
	public void testSearch() throws Exception {
		Display testSubject;

		// default test
		testSubject = createTestSubject();
		testSubject.search();
	}

	@MethodRef(name = "insertUpdate", signature = "(QDocumentEvent;)V")
	@Test
	public void testInsertUpdate() throws Exception {
		Display testSubject;
		DocumentEvent e = null;

		// default test
		testSubject = createTestSubject();
		testSubject.insertUpdate(e);
	}

	@MethodRef(name = "removeUpdate", signature = "(QDocumentEvent;)V")
	@Test
	public void testRemoveUpdate() throws Exception {
		Display testSubject;
		DocumentEvent e = null;

		// default test
		testSubject = createTestSubject();
		testSubject.removeUpdate(e);
	}

	@MethodRef(name = "changedUpdate", signature = "(QDocumentEvent;)V")
	@Test
	public void testChangedUpdate() throws Exception {
		Display testSubject;
		DocumentEvent e = null;

		// default test
		testSubject = createTestSubject();
		testSubject.changedUpdate(e);
	}
}