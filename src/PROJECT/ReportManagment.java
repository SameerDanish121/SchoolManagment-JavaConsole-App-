package PROJECT;

import java.sql.ResultSet;
import java.util.Scanner;
import myprojectt.DSA;
public class ReportManagment{
	Scanner sc=new Scanner(System.in);
	Student[] s1;
	Teacher[] t1;
	Admin a=new Admin();
	public void RetriveSubject() {
		try {
			DSA D=new DSA();
			String query="select *from Subject";
			ResultSet res=D.select(query);
			while(res.next()) {
				s.insert(res.getString(1), res.getInt(2));
			}
		}catch(Exception e) {}
	}
	public void saveSubject() {
		ESubejct();
		if(s.Subject==null) {
			System.out.println("NO SUBJECt");
		}else {
			try {		
		for(int i=0;i<s.Subject.length;i++) {
			if(s.Subject[i]==null) { 
				i=s.Subject.length;
			}else {
			 DSA d=new DSA();
			String query=String.format("insert into Subject values('%s','%s')",s.Subject[i],s.SID[i]);
			d.insertUpdateDelete(query);}
		}
			}catch(Exception e) {}
		}
	}
	public void InsertStudent(Student s) {
		if(s1==null) {
			s1=new Student[1];
			s1[0]=s;}
		else {
			Student temp[]=new Student[s1.length+1];
			for(int index=0;index<s1.length;index++) {
				temp[index]=new Student();
				temp[index]=s1[index];
			}
			temp[temp.length-1]=s;
			s1=temp;
		}
		}

	public void InsetTeacher() {
		Teacher t=new Teacher();
		t.getSubejct(s);
		t.Input();
		if(t1==null) {
			t1=new Teacher[1];
			t1[0]=t;}
		else {
			Teacher temp[]=new Teacher[t1.length+1];
			for(int index=0;index<t1.length;index++) {
				temp[index]=new Teacher();
				temp[index]=t1[index];
			}
			temp[temp.length-1]=t;
			t1=temp;
		}
		}
	public void deleteStudent(){
		if(s1==null) {
			System.out.println("NO RECORD EXIST!");}else {
		System.out.println("Enter id of the Student you want to delete:");
		int id=sc.nextInt();
		Student temp[]=new Student[s1.length-1];
		int TempI=0;  
		for(int index=0;index<s1.length;index++) {
			if(s1[index].ID!=id) {
				
				temp[TempI]=new Student();
				temp[TempI]=s1[index];
				TempI++;
			}else {
				System.out.println("Deleted");
			}
			
		}
		s1=temp;
		}
		}
    public void deleteTeacher(){
	if(t1==null) {
		System.out.println("NO TEACHER EXIST");}else {
	System.out.println("Enter id of the Teacher you want to delete:");
	int id=sc.nextInt();
	Teacher tempt[]=new Teacher[t1.length-1];
	int TempIT=0;
	for(int index=0;index<t1.length;index++) {
		if(id!=t1[index].ID) {
			
			tempt[TempIT]=new Teacher();
			tempt[TempIT]=t1[index];
			TempIT++;
			
		}
		else {
			System.out.println("Deleted");
		}
		}
		
	t1=tempt;
	}}
	public void showALLTeacher() {
		if(t1==null) {
			System.out.println("NO TEACHER EXIST");
			}else
	{for(int i=0;i<t1.length;i++) {
		System.out.println("---------------------------------------------");
		System.out.println(i+1+"---->");
			t1[i].Display();}
	}}
	public void showALLStudent() {
		if(s1==null) {
			System.out.println("NO DATA");
		}else {
		for(int i=0;i<s1.length;i++) {
			
			System.out.println(i+1+"---->");
			s1[i].Display();
			s1[i].DisplayReportCard();
			}
		}}
	public void UpdateStudent() {
		System.out.println("Enter the id of Student you want to update :");
		Scanner sc=new Scanner(System.in);
		int UID=sc.nextInt();
		for(int o=0;o<s1.length;o++) {
		if(UID==s1[o].ID) { 
			System.out.println("BEFORE UPDATE:");
			s1[o].Display();
			s1[o].DisplayReportCard();
			s1[o].getSubject(s);
			s1[o].Input();
		//	s1[o].insertReportCard();
			System.out.println("After UPDATE:");
			s1[o].Display();
			s1[o].DisplayReportCard();
		}else {
			System.out.println("Record DoesnOT exist");
		}
			}
	}
	public void UpdateReportCard() {
		System.out.println("Enter the id of Student you want to update :");
		Scanner sc=new Scanner(System.in);
		int UID=sc.nextInt();
		for(int o=0;o<s1.length;o++) {
		if(UID==s1[o].ID) {
			System.out.println("BEFORE UPDATE:");
			System.out.println(s1[o].name);
			s1[o].DisplayReportCard();
			System.out.println("Please RE-ENTER THE ABOVE DATA TO RE_WRITE REPORT CARD:");
			s1[o].insertReportCard();
			System.out.println("After UPDATE:");
			s1[o].Display();
			s1[o].DisplayReportCard();
		}else {
			System.out.println("Record DoesnOT exist");
		}
			}
	}	
	public void UpddateTeacher() {
		System.out.println("Enter the id of Teacher you want to update :");
		Scanner sa=new Scanner(System.in);
		int UID=sa.nextInt();
		for(int o=0;o<t1.length;o++) {
		if(UID==t1[o].ID) {
			System.out.println("BEFORE UPDATE:");
			t1[o].Display();
			t1[o].getSubejct(s);
			t1[o].Input();
			System.out.println("After Update:");
			t1[o].Display();
		}else {
			System.out.println("Record DoesnOT exist");
		}
			}
	}	
	public void showALLAdmin() {
		a.Display();
	}
	public void addTeacher(Teacher T) {
		if(t1==null) {
			t1=new Teacher[1];
			t1[0]=new Teacher(T);}else {
				Teacher tempT[]=new Teacher[t1.length+1];
				for(int index=0;index<t1.length;index++) {
					tempT[index]=t1[index];
				}
				tempT[t1.length]=new Teacher(T);
				t1=tempT;
		}
	}
	
	public void UpdateStudentpass(int user,int j) {
		for(int i1=0;i1<s1.length;i1++) {
			if(user==s1[i1].password) {
				//System.out.printf("Enter your new Password");
				s1[i1].password=j;
			}
		}
        }
	public void UpdateTeacherpass(int pass,String user) {
		for(int i1=0;i1<t1.length;i1++) {
			if(user.equals(t1[i1].Username)) {
				t1[i1].setPassword(pass);
			}
		}
	}
public void ShowReporCardtByID(int a) {
		for(int i=0;i<s1.length;i++) {
		if(a==s1[i].password) {
			s1[i].DisplayReportCard();
		}else {}
		}
	}
public void SearchStudent() {
	System.out.println("Enter id of the Student you Want TO Search:");
	int a=sc.nextInt();
	for(int i=0;i<s1.length;i++) {
		if(a==s1[i].ID) {
			s1[i].Display();
			s1[i].DisplayReportCard();
		}
	}
}

public void SearchTeacher() {
	System.out.println("Enter id of the Teacher you Want TO Search:");
	int a=sc.nextInt();
	for(int k=0;k<t1.length;k++) {
		if(a==t1[k].ID) {
			t1[k].Display();
			
		}
	}
	}
public void UpdateAdminpass(int pass,int j) {
			a.setPassword(j);	}
Report R[];
public int getMin() {
	if(R==null) {
		return -1;
	}else {
		int i=R[0].no;
		for(int j=0;j<R.length;j++) {
			if(R[j].no<i) {
				i=R[j].no;
			}
		}
		return i;
	}
}
public int getMax() {
	if(R==null) {
		return -1;
	}else {
		int i=R[0].no;
		for(int j=0;j<R.length;j++) {
			if(R[j].no<i) {
				i=R[j].no;
			}
		}
		return i;
	}
}
public void insertProblem(Report r) {
	if(R==null) {
		R=new Report[1];
		R[0]=r;}
		else {
			Report[] g=new Report[R.length+1];
			for(int i=0;i<R.length;i++) {
				g[i]=R[i];
			}
			g[R.length]=r;
			R=g;
		}
	}
public void SException() {
	try {
		DSA D=new DSA();
		String query1="truncate table student";
		D.select(query1);}catch(Exception e) {}
}
public void saveStudent() {
	SException();
	try {
		DSA d=new DSA();
	for(int i=0;i<s1.length;i++) {
		String query=String.format("insert into student values('%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s')",s1[i].ID,s1[i].name,s1[i].Username,s1[i].password,s1[i].Subject[0],s1[i].Subject[1],s1[i].Subject[2],s1[i].Subject[3],s1[i].Subject[4], s1[i].a.attendedLecture,32,s1[i].a.absents,s1[i].a.percentage,s1[i].r.totalMarks,s1[i].r.obtainedMarks,s1[i].r.percentage,s1[i].r.Remarks,s1[i].Section);
		d.insertUpdateDelete(query);
		}
	System.out.println("Saved");
	}catch(Exception e) {}
}
public void Exception() {
	try {
		DSA D=new DSA();
		String query1="truncate table Teacher";
		D.select(query1);}catch(Exception e) {}
}
public void SaveTeacher() {
	Exception();
	try {
		DSA d=new DSA();
		for(int i=0;i<t1.length;i++) {
		String query=String.format("insert into Teacher values('%s','%s','%s','%s','%s')", t1[i].ID,t1[i].name,t1[i].Username,t1[i].password,t1[i].subject);
	d.insertUpdateDelete(query);
		}
		System.out.println("Saved");
		}catch(Exception e) {}
	}	
public void RetriveStudent() {
	try {
		DSA  D=new DSA ();
		String query="select *from  student";
		ResultSet res=D.select(query);
		while(res.next()) {
			Student  s1=new Student();
			s1.GetData(res.getInt(1), res.getString(2),  res.getString(3),  res.getInt(4), res.getString(5), res.getString(6), res.getString(7),  res.getString(8),  res.getString(9),  res.getInt(11),  res.getInt(12),  res.getDouble(13),  res.getInt(14), res.getInt(15), res.getDouble(16), res.getString(17),res.getString(18));
		InsertStudent(s1);
		}
	}catch(Exception e) {}
}
public void retriveProblem() {
	
	try {
		DSA D=new DSA();
		String query="select *from Report";
		 ResultSet res=D.select(query);
		 while(res.next()) {
			 Report rp=new Report();
			 rp.Report=res.getString(1);
			 rp.no=res.getInt(2);
			 insertProblem(rp);
		 }
		
	}catch(Exception e) {}
}
public Report deleteReport(int n) {
	if(R==null) {
		return null;
	}else {
		Report y=null;
		Report temp[]=new Report[R.length-1];
		int temp3=0;
		for(int i=0;i<R.length;i++) {
			if(R[i].no!=n) {
				temp[temp3]=R[i];
				temp3++;
			}else {
				y=R[i];
			}
		}
		R=temp;
		return y;
	}
}
public void showAllProblem() {
	if(R==null) {
		System.out.println("NO data to Show");
	}else {
		System.out.println("NO      PROBLEMS");
		System.out.println("-----------------");
	for(int k=0;k<R.length;k++) {
	R[k].display();
	}}
}

public int verifiactionOfAdmin(int pass,String username) {
	int i=0;
	if(pass==a.AdminPass&&a.UserName.equals(username)) {
		i=1;
	}else {
		i=0;}
	return i;
}
public int verifiactionOfTeacher(int pass,String username) {
int i1=0;
	if(t1==null) {
		i1=0;
	}else {
	for(int i=0;i<t1.length;i++) {
	if(pass==t1[i].password||t1[i].Username.equals(username)) {
		i1=3;
	}else {
		
	}}}
	return i1;
}
public int verifiactionOfStudent(int pass,String username) {
int i2=0;
	if(s1==null) {
	i2=0;
	}else {
	for(int i=0;i<s1.length;i++) {
	if(pass==s1[i].password&&s1[i].Username.equals(username)) {
		i2=2;
	}else {
		}}}
	return i2;
}
public void viewStudentByID1(int pass) {
	for(int i=0;i<s1.length;i++) {
		if(pass==s1[i].password) {
			s1[i].Display();
		}else {}
	}
}
public void viewStudentByID(int pass) {
	for(int i=0;i<s1.length;i++) {
		if(pass==s1[i].ID) {
			s1[i].Display();
		}else {}
	}
}
public void viewTeacherByID(int pass) {
	if(t1==null) {
		System.out.println("NO RECORD");
	}else {
	for(int i=0;i<t1.length;i++) {
		if(pass==t1[i].password) {
			t1[i].Display();
		}else {}
	}
}}
public void saveProblem() {
	EReport();
	try {
		DSA d=new DSA();
		for(int i=0;i<R.length;i++) {
		String query=String.format("insert into Report values('%s','%s')",R[i].Report,R[i].no);
		d.insertUpdateDelete(query);
		}
		System.out.println("Saved");
	}catch(Exception e) {}
}
Subject s=new Subject();
public void RetriveTeacher() {
	try {
		DSA d=new DSA();
		String query="select *from Teacher";
		ResultSet res=d.select(query);
		while(res.next()) {
			Teacher t=new Teacher();
			t.ID=res.getInt(1);
			t.name=res.getString(2);
			t.Username=res.getString(3);
			t.password=res.getInt(4);
			t.subject=res.getString(5);
			addTeacher(t);
		}
			}catch(Exception e) {}
}
public void ESubejct() {
	try {
		DSA D=new DSA();
		String query1="truncate table Subject";
		D.select(query1);}catch(Exception e) {}
}
public void EReport() {
	try {
		DSA D=new DSA();
		String query1="truncate table Report";
		D.select(query1);}catch(Exception e) {}
}
public void Menu() {
	System.out.println("`````WELCOME TO BIIT REPORT CARD SYSTEM```````        ");
	System.out.println("");
	    RetriveStudent();
	    RetriveTeacher();
	    retriveProblem();
	    RetriveSubject();
	    int userVerfication=0;
	do{
		System.out.println("          ================");
		System.out.println("          | LOGIN PORTAL |");
		System.out.println("          ================");
		System.out.println("");
	    System.out.println("   1). LOGIN");
	    System.out.println("   2). EXIT");
	    System.out.println("");
System.out.print("Enter----->");	userVerfication=sc.nextInt();
if(userVerfication==1) {
	System.out.println("");
	System.out.println("i). USERNAME :");
	String user=sc.next();
	System.out.println("ii).Enter PASSWORD :");
	int pass=sc.nextInt();
         if(verifiactionOfAdmin(pass,user)==1) {
		System.out.println("        You Login AS a Admin    ");
		System.out.println("");
		int Achoice=0;
		
		do{
			System.out.println("-------------------------------------------------------------------------------------------------------------");
		System.out.println("1)  VIEW ALL Your info");
		System.out.println("2)  VIEW ALL THE STUDENT");
		System.out.println("3)  VIEW ALL THE TEACHER");
		System.out.println("4)  INSERT NEW STUDENT");
		System.out.println("5)  INSERT NEW TEACHER");
		System.out.println("6)  VIEW REPORTS OR APPLCATIONS");
		System.out.println("7)  Delete Student");
	    System.out.println("8)  Delete TEACHER");
		System.out.println("9)  Update Student");
		System.out.println("10) Update  Teacher");
		System.out.println("11) Search  Teacher");
		System.out.println("12) Search  Student");
		System.out.println("13) Save Student");
		System.out.println("14) Save Teacher");
		System.out.println("15) Update your password");
		System.out.println("16) Process Applications/Problems/FEEDBACKS");
	    System.out.println("17) Manage Subjects");
		System.out.println("18) LOGOUT");
		System.out.println("-------------------------------------------------------------------------------------------------------------");
		System.out.print("Enter----->");Achoice=sc.nextInt();
		System.out.println("-------------------------------------------------------------------------------------------------------------");
		switch(Achoice) {
		case 1:
			showALLAdmin();
			break;
		case 2:
			showALLStudent();
			break;
		case 3:
			showALLTeacher();
			break;
		case 4:
			Student t=new Student();
			t.getSubject(s);
			t.Input();
			InsertStudent(t);
			break;
		case 5:
			InsetTeacher();
			break;
		case 6:
			showAllProblem();
			break;
		case 7:
			deleteStudent();
			break;
		case 8:
			deleteTeacher();
			break;
		case 9:
			UpdateStudent();
			break;
		case 10:
			UpddateTeacher();
			break;
		case 11:
			SearchTeacher();
			break;
		case 12:
			SearchStudent();
			break;
		case 13:
			saveStudent();
			break;
		case 14:
			SaveTeacher();
			break;
		case 15: 
			System.out.println("Enter new PassWord");
			a.AdminPass=sc.nextInt();
			pass=a.AdminPass;
			break;
		case 16:
			if(R==null) {System.out.println("NO APPLICATION/FEEDBACK/REPORTS TO BE EXECUTED");}else{
			if(getMin()==-1) {
				System.out.println("NO APPLICATION/FEEDBACK/REPORTS TO BE EXECUTED");
			}else {
				Report k;
	k=deleteReport(getMin());
	System.out.println("THE NEXT APPLICATION/FEEDBACK/REPORT IS PROCESSED");
	k.display();
			}}
			break;
		case 17:
			System.out.println("SUBJECT MANAGMENT");
			int e=0;
			do{
				System.out.println("-------------------------------------------------------------------------------------------------------------");
			System.out.println("1). DISPLAY ALL SUBJECTS");
			System.out.println("2). REMOVE SUBJECT");
			System.out.println("3). ADD NEW SUBJECT");
			System.out.println("4). SaveChanges");
			System.out.println("5). Exit");
			System.out.println("-------------------------------------------------------------------------------------------------------------");
			e=sc.nextInt();
			if(e==1) {
				s.DisplaySubject();
			}else if(e==2) {
				s.RemoveSubject(); 
			}
			else if(e==3) {
				System.out.println("ENTER NAME OF THE SUBJECT");
				String r=sc.next();
				System.out.println("ENTER ID OF THE SUBJECT");
				int y=sc.nextInt();
				s.insert(r, y);
			}else if(e==4) {
				saveSubject();
				System.out.println("Subject Saved");
			}
			}while(e!=5);
			break;
		}
		
		}while(Achoice!=18);
	}
else if(verifiactionOfStudent(pass,user)==2) {
		System.out.println("            You Login AS a Student");
        int Schoice=0;
		do {
		System.out.println("");
		System.out.println("-------------------------------------------------------------------------------------------------------------");
		System.out.println("1) . View Your your Basic infromation ");
		System.out.println("2) . View Your Report Card ");
		System.out.println("3) . update your password");
		System.out.println("4) .  submit your application/report/FEEDBACK");
		System.out.println("5) . Save ALL THE Data");
		System.out.println("6) . View All the Teachers and Their Regarding Subjects:");
		System.out.println("7) . LOGOUT:");
		System.out.println("-------------------------------------------------------------------------------------------------------------");
	 System.out.print("Enter------->");   Schoice=sc.nextInt();
		System.out.println("-------------------------------------------------------------------------------------------------------------");
		switch(Schoice) {
		case 1:
			viewStudentByID1(pass);
			break;
		case 2:
			ShowReporCardtByID(pass);
			break;
		case 3:
			System.out.printf("Enter your new Password");
			int j=sc.nextInt();
			UpdateStudentpass(pass,j);
			System.out.println("updated!");
			pass=j;
			break;
		case 4:
		Report rj=new Report();
		rj.input();
		if(getMax()==-1) {
			rj.no=1;
			insertProblem(rj);
			}else {
		rj.getNo(getMax()+1);
			insertProblem(rj);}
			break;
		case 5:
			saveStudent();
			saveProblem();
			break;
		case 6:
			System.out.println("   TEACHERS ARE AS FOLLOW :");
			showALLTeacher();
			System.out.println(" ");
			System.out.println("   Subjects Are AS FOLLOW :");
			s.DisplaySubject();
			break;
		}
		}while(Schoice!=7);
	}
else if(verifiactionOfTeacher(pass,user)==3) {
	int tchoice=0;
		System.out.println("            You Login AS a Teacher");
		System.out.println("");
		do{
			System.out.println("-------------------------------------------------------------------------------------------------------------");
			System.out.println("1) . view your BASIC INFORMATION");
		System.out.println("2) . VIEW ALL THE STUDENTS AND THEIR REPORT CARD");
		System.out.println("3) . VIEW STUDENT BY ID");
		System.out.println("4) . INSERT NEW STUDENT AND REPORT CARD ");
		System.out.println("5) . UPDATE STUDENT REPORT CARD");
		System.out.println("6) . UPDATE STUDENT FULL INFO ");
		System.out.println("7) . DELETE STUDENT ");
		System.out.println("8) . VIEW ALL Problems");
		System.out.println("9) . Save ALL CHANGES");
		System.out.println("10) . LOGOUT");
		System.out.println("-------------------------------------------------------------------------------------------------------------");
	System.out.println("Enter----->");	tchoice=sc.nextInt();
		System.out.println("-------------------------------------------------------------------------------------------------------------");
		switch(tchoice) {
		case 1:
			viewTeacherByID(pass);
			break;
		case 2:
			showALLStudent();
			break;
		case 3:
			System.out.println("ENTER THE ID OF STUDENT :");
			int l=sc.nextInt();
			viewStudentByID(l);
			break;
		case 4:
			Student g=new Student();
			g.Input();
			g.getSubject(s);
			InsertStudent(g);
			break;
		case 5:
			 UpdateReportCard();
			break;
		case 6:
			 UpdateStudent();
		break;
		case 7:
			deleteStudent();
			break;
		case 8:
			showAllProblem();
			break;
		case 9:
			SaveTeacher();
			saveStudent();
			
			break;
		}
			
		}while(tchoice!=10);
	}
else {
		System.out.println("NOT A RECOGNIZED USER");}
		}
}while(userVerfication!=2);
	
}
}
