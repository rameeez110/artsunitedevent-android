package com.example.artsunitedeventforms.Utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.pdf.PdfRenderer;
import android.os.ParcelFileDescriptor;
import android.util.DisplayMetrics;
import android.view.View;

import com.example.artsunitedeventforms.data.local.Question;
import com.example.artsunitedeventforms.views.ui.MainActivity;
import com.github.barteksc.pdfviewer.util.Util;
import com.tejpratapsingh.pdfcreator.utils.FileManager;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;


public class PdfHelper {
	
	public static File createFile(Context context) {
		
		//FileManager.getInstance().cleanTempFolder(context);
		//final File savedPDFFile = FileManager.getInstance().createTempFile(context, "pdf", false);
		File file = new File(context.getExternalFilesDir("formDocs").getPath(),
				"formdata.pdf");
		
		return file;
	}
	
	
	public static String getHtmlString(String title, ArrayList<Question> questions) {
		
		String paragraphString = "";
		paragraphString = paragraphString.concat(getPdfHeader(title));
		paragraphString = paragraphString.concat(getDate());
		paragraphString = paragraphString.concat(getParagraphs(questions));
		return createHtmlPdfCode(paragraphString);
	}
	
	
	public static String getDate() {
		
		String marginTop = "0.3mm";
		String date = Utils.getCurrentDate("dd MMM yyyy");
		
		String left = String.format("<p %s>Today's Date</p>", getLeftParaStyle(marginTop));
		String right = String.format("<p %s>%s</p>", getRightParaStyle(marginTop), date);
		
		return left.concat("\n").concat(right);
	}
	
	
	public static String getPdfHeader(String title) {
		
		return String.format("<h2 style=\"text-align: center\">%s</h2>\n", title);
	}
	
	
	public static String getParagraphs(ArrayList<Question> questions) {
		
		String paragraphs = "";
		if (questions == null || questions.size() == 0)
			return paragraphs;
		
		for (Question question : questions) {
			paragraphs = paragraphs + getParagraph(question) + "\n";
		}
		return paragraphs;
	}
	
	
	public static String getParagraph(Question question) {
		
		String marginTop = "0.1mm";
		String left = String.format("<p %s>%s</p>",
				getLeftParaStyle(marginTop), question.getQuestion());
		
		String right = String.format("<p %s>%s</p>",
				getRightParaStyle(marginTop),
				Utils.getAnswerFromType(question,question.getAnswer()));
		
		
		return left.concat("\n").concat(right);
	}
	
	
	private static String getLeftParaStyle(String marginTop) {
		
		return "style=\"text-align: left;margin-top: " + marginTop +
				";vertical-align: top; width:49%; display: inline-block;\"";
	}
	
	
	private static String getRightParaStyle(String marginTop) {
		
		return "style=\"text-align: right;margin-top: "+ marginTop +
				";vertical-align: top; width:50%; display: inline-block;\"";
	}
	
	
	private static String createHtmlPdfCode(String data) {
		
		return "<!DOCTYPE html>".concat("\n")
				.concat("<html>").concat("\n")
				.concat("<body>").concat("\n")
				.concat(data).concat("\n")
				.concat("</body>").concat("\n")
				.concat("</html>");
	}
	
}
