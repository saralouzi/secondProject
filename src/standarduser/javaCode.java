package standarduser;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class javaCode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
// datatypes 
		int myAge = 30;
		// float myWeight = 94.5f (hoon lazm adeef el f b3d el raqam mshan ma ydal 3ndi
		// mshakel or data mismatch)
		double myHeight = 173.5;
		// (lw kan double w ana ma hattet eshi b3dd el fasle its fine lhalo bdeef .0)
		String myName = "abdulraheem";
		char myFirstLetter = 'A';
		boolean IAmJordanian = true; // anything that can be given as true or false info
		boolean IamJordanian = false; // if i have an expected value to be present rh y36eni true
										// If not present then false

		// if i have 10 students and need to list everyone i cant keep writing String
		// firstStudent = "ahmad"; .... till im done with all students i need to use
		// smth faster like ARRAY or LIST

		String[] myStudents = { "ahmad", "amneh", "anas", "omar", "sara", "ahmad", "amneh", "anas", "omar", "sara",
				"ahmad", "amneh", "anas", "omar", "sara", "ahmad", "amneh", "anas", "omar", "sara", "ahmad", "amneh",
				"anas", "omar", "sara", "ahmad", "amneh", "anas", "omar", "sara", "ahmad", "amneh", "anas", "omar",
				"sara", "ahmad", "amneh", "anas", "omar", "sara", "ahmad", "amneh", "anas", "omar", "sara", "ahmad",
				"amneh", "anas", "omar", "sara"};
		// data values are entered by the dev so values are constants unless i make
		// changes on them
		// meaning theyre STATIC VALUES
		// hoon ana bdeef el data for everyone all in one code line bdal ,a ykono 10
		// lines
		// عشان اقدر اشوف مثلا عنصرمعين في الداتا كاملة بستخدم جملة طباعة sysout +
		// ctrl+space
		// inside () name of string , inside [] number of element to be printed

		System.out.println(myStudents.length);
// to print last value = length-1 (first value always =0)//here length = 50 if i request to print [50]error out of bound
// length = العدد الكامل الهم \ INDEX = موقع هاي العينة من الترتيب 
		System.out.println(myStudents [49]);//النتيجة هون رح تطلع SARA 
		
		
	}

}
