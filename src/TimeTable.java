/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.*;
import java.io.*;
/**
 *
 * @author refing
 */
public class TimeTable {
  
    public static void main(String[] args){
        
        String test_crs = "D:\\Toronto\\testing.crs";
        String test_stu = "D:\\Toronto\\testing.stu";
        
        String carf92_crs = "D:\\Toronto\\car-f-92.crs";
        String carf92_stu = "D:\\Toronto\\car-f-92.stu";

        String cars91_crs = "D:\\Toronto\\car-s-91.crs";
        String cars91_stu = "D:\\Toronto\\car-s-91.stu";

        String earf83_crs = "D:\\Toronto\\ear-f-83.crs";
        String earf83_stu = "D:\\Toronto\\ear-f-83.stu";

        String hecs92_crs = "D:\\Toronto\\hec-s-92.crs";
        String hecs92_stu = "D:\\Toronto\\hec-s-92.stu";

        String kfus93_crs = "D:\\Toronto\\kfu-s-93.crs";
        String kfus93_stu = "D:\\Toronto\\kfu-s-93.stu";

        String lsef91_crs = "D:\\Toronto\\lse-f-91.crs";
        String lsef91_stu = "D:\\Toronto\\lse-f-91.stu";

        String purs93_crs = "D:\\Toronto\\pur-s-93.crs";
        String purs93_stu = "D:\\Toronto\\pur-s-93.stu";

        String ryes93_crs = "D:\\Toronto\\rye-s-93.crs";
        String ryes93_stu = "D:\\Toronto\\rye-s-93.stu";

        String staf83_crs = "D:\\Toronto\\sta-f-83.crs";
        String staf83_stu = "D:\\Toronto\\sta-f-83.stu";

        String tres92_crs = "D:\\Toronto\\tre-s-92.crs";
        String tres92_stu = "D:\\Toronto\\tre-s-92.stu";

        String utas92_crs = "D:\\Toronto\\uta-s-92.crs";
        String utas92_stu = "D:\\Toronto\\uta-s-92.stu";

        String utes92_crs = "D:\\Toronto\\ute-s-92.crs";
        String utes92_stu = "D:\\Toronto\\ute-s-92.stu";

        String yorf83_crs = "D:\\Toronto\\yor-f-83.crs";
        String yorf83_stu = "D:\\Toronto\\yor-f-83.stu";
        
        Scanner in = new Scanner(System.in);
        System.out.println("Toronto Course Timetabling");
            System.out.println("1. CAR-F-92");
            System.out.println("2. CAR-S-91");
            System.out.println("3. EAR-F-83");
            System.out.println("4. HEC-S-92");
            System.out.println("5. KFU-S-93");
            System.out.println("6. LSE-F-91");
            System.out.println("7. PUR-S-93");
            System.out.println("8. RYE-S-93");
            System.out.println("9. STA-F-83");
            System.out.println("10. TRE-S-92");
            System.out.println("11. UTA-S-92");
            System.out.println("12. UTE-S-92");
            System.out.println("13. YOR-F-83");
            System.out.println("0. EXIT");
            
            System.out.println("ENTER NUMBER:");
            int input = in.nextInt();
            
            switch(input) {
                case 1 :
                    timetabling(carf92_crs, carf92_stu, "Carleton92");
                    break;
                case 2 :
                    timetabling(cars91_crs, cars91_stu,"Carleton91");
                    break;
                case 3 :
                    timetabling(earf83_crs, earf83_stu,"EarlHaig83");
                    break;
                case 4 :
                    timetabling(hecs92_crs, hecs92_stu,"EdHEC92");
                    break;
                case 5 :
                    timetabling(kfus93_crs, kfus93_stu,"KingFahd93");
                    break;
                case 6 :
                    timetabling(lsef91_crs, lsef91_stu,"LSE91");
                    break;
                case 7 :
                    timetabling(purs93_crs, purs93_stu,"pur93");
                    break;
                case 8 :
                    timetabling(ryes93_crs, ryes93_stu,"rye93");
                    break;
                case 9 :
                    timetabling(staf83_crs, staf83_stu,"St.Andrews83");
                    break;
                case 10 :
                    timetabling(tres92_crs, tres92_stu,"Trent92");
                    break;
                case 11 :
                    timetabling(utas92_crs, utas92_stu,"TorontoAS92");
                    break;
                case 12 :
                    timetabling(utes92_crs, utes92_stu,"TorontoE92");
                    break;
                case 13 :
                    timetabling(yorf83_crs, yorf83_stu,"YorkMills83");
                    break;
                    
		case 14 :
                    timetabling(test_crs, test_stu,"test");
                    break;
		
		case 0 :
                    System.out.println("exit");
                    break;
		default :
                    break;
		}
		
		in.close();
    }
    
    public static void timetabling(String crs, String stu, String filename){
        ArrayList<String> course; 
        ArrayList<String> scourse;
        ArrayList<String> student;
        int[][] conflict_matrix;
        try {
            
            FileReader fcr = new FileReader(crs);
            BufferedReader cr = new BufferedReader(fcr);
            
            FileReader fst = new FileReader(stu);
            BufferedReader st = new BufferedReader(fst);
            
            
            course = new ArrayList<String>();
            scourse = new ArrayList<String>();
            String courseLine = null;
            while((courseLine = cr.readLine()) != null) {
                    String[] arr = courseLine.split(" ");
                    course.add(arr[0]);
                    scourse.add(arr[0]);
            }
            System.out.println("jumlah course:");
            System.out.println(course);
            System.out.println("");
            
            student = new ArrayList<String>();
            conflict_matrix = new int[course.size()][course.size()];
            
            String StudentLine = null;
            while((StudentLine = st.readLine()) != null) {
                String[] arr = StudentLine.split(" ");
                
                if(arr.length > 0) {
                    for(int i = 0; i < arr.length-1; i++) {
                        for(int j = i+1; j < arr.length; j++) {
                            int index1 = Integer.parseInt(arr[i]);
                            int index2 = Integer.parseInt(arr[j]);
                            
                            conflict_matrix[index1-1][index2-1]++;
                            conflict_matrix[index2-1][index1-1]++;
                        }
                    }
                }
                student.add(arr[0]);
            }
            
            System.out.println("conflict student mengambil dua course");
            for(int i = 0; i < conflict_matrix.length; i++) {
                for(int j = 0; j < conflict_matrix.length; j++) {
                    System.out.print(conflict_matrix[i][j] + " ");
                }
                System.out.println();
            }
            
            
            System.out.println("conflict binary");
            int[][] binary = conflict_matrix;
		for(int i = 0; i < conflict_matrix.length; i++) {
                    for(int j = 0; j < conflict_matrix.length; j++) {
                        if(conflict_matrix[i][j] > 0)
                                binary[i][j] = 1;
                        System.out.print(binary[i][j]+" ");
                    }
                    System.out.println();
		}
            
            int[][]degrees = new int[course.size()][2];
            for(int i=0;i<degrees.length;i++){
                degrees[i][0]=i+1;
            }
            
            int sum = 0;
            for(int i = 0; i < conflict_matrix.length; i++) {
                for(int j = 0; j < conflict_matrix.length; j++) {
                    
                    if(conflict_matrix[i][j] != 0){
                        sum++;
                    }
                }
                degrees[i][1]=sum;
                sum=0;
            }
            System.out.println("Degree course:");
            
            for(int i = 0; i < degrees.length;i++){
                for(int j=0;j<2;j++){
                    System.out.print(degrees[i][j]+" ");
                }
                System.out.println("");
            }
            
            
        
            
//            int n = sdegrees.length;
//            for (int i=0;i<n-1;i++){
//                int max = i;
//                for(int j=i+1;j<n;j++){
//                    if(sdegrees[i][j]>sdegrees[i][max])
//                        max=j;
//                }
//                //Collections.swap(scourse,max,i);
//                
//                int temp = sdegrees[i][max];
////                index[i]=sdegree[max];
//                sdegrees[i][max]=sdegrees[i][1];
//                sdegrees[i][1]=temp;
//            }
//            
//            System.out.println("");
//            System.out.println("sorted degree:");
//            for(int i = 0; i < sdegrees.length;i++){
//                for(int j=0;j<2;j++){
//                    System.out.println(sdegrees[i][j]);
//                }
//            }
            
            
//            System.out.println("scourse");
//            System.out.print(scourse);
//            System.out.println("");
//            System.out.println("course");
//            System.out.print(course);
            
//            int[][] conflictcourse = new int[course.size()][];
//            
//            for (int i = 0; i<course.size();i++){
//                ArrayList<Integer> temp = new ArrayList<Integer>();
//                for(int j=0;j<conflict_matrix[i].length;j++){
//                    int conflict = conflict_matrix[i][j];
//                    if(conflict >= 1 && i != j){
//                        temp.add(j);
//                    }
//                }
//                int[]arraytemp = new int[temp.size()];
//                for (int j=0;j<temp.size();j++){
//                    arraytemp[j]=temp.get(j);
//                }
//                conflictcourse[i]=arraytemp;
//            }
//            
//            System.out.println("");
//            System.out.println("conflict course");
//            for(int i = 0; i < conflictcourse.length; i++) {
//                for(int j = 0; j < conflictcourse[i].length; j++) {
//                    System.out.print(conflictcourse[i][j] + " ");
//                }
//                System.out.println();
//            }
            
            int ts=1;
            int [][] timeslot = new int[course.size()][2];
            
            int[][]sdegrees = new int[course.size()][2];    
            sdegrees=degrees;
           
            
            Arrays.sort(sdegrees, new Comparator<int[]>() { 
		@Override
		public int compare(int[] entry1, int[] entry2) { 
                    if (entry1[1] < entry2[1]) 
                        return 1; 
                    else
                        return -1; 
                  } 
                });
                // display array after sort
                System.out.println("");
                System.out.println("degree sorted in descending order");
                for(int i = 0; i < sdegrees.length;i++){
                    for(int j=0;j<2;j++){
                        System.out.print(sdegrees[i][j]+" ");
                    }
                    System.out.println("");
                }   

//            for(int i=0; i<timeslot.length; i++)
//                {
//                        for(int j=0; j<timeslot[i].length; j++)
//                        {
//                                timeslot[i][0] = i+1;
////                                timeslot[i][1] = -1;
//                        }
//                }

            //timesloting
            //start timer
            long starttimer = System.nanoTime();
            for(int i=0; i<sdegrees.length; i++){
                    for(int j=0; j<ts; j++){
                            if(issafe(i, j, conflict_matrix, sdegrees, timeslot)){
                                    timeslot[sdegrees[i][0]-1][1] = j;
                                    break;
                            }else{
                                    ts++;
                            }
                    }
            }
             
            
            
//            int ts=1;
//            for(int i=0; i<course.size();i++){
//                for(int j=0; j<ts; j++){
//                    if(conflict_matrix[sdegrees[i][0]-1][i]==0 && timeslot[i][1] != j)
//                    {timeslot[sdegrees[i][0]-1][1] = j;
//                        break;
//                    }else
//                        ts++;
//                }   
//            }

                
            
            System.out.println("");
            System.out.println("timetable");
            for(int i = 0; i < timeslot.length;i++){
                for(int j=0;j<timeslot[i].length;j++){
                    timeslot[i][0] = i+1;
                    System.out.print(timeslot[i][j]+" ");
                }
                System.out.println("");
            }    
            // end timer
            long endtimer   = System.nanoTime();
            long totaltimer = endtimer - starttimer;
            
            System.out.println("waktu eksekusi : " + (double)totaltimer/1000000000 + " detik");
            
            
            //export
            export(timeslot,filename);
            
            ///////////////////////////////////////////////////////////////////
            //penalty cij
            double penalty = 0;
            
            //jumlah jumlah siswa yang mengambil dua course i j bersamaan x 2 pgkt(5-abs tj-ti) 
            //penalty = (cij*(Math.pow(2, (5-(Math.abs(tj - ti))))))/student.size();
            
            //hill climbing
            
            
            
        } catch(Exception e) {
            System.out.println("error: " + e);
        }
    }
    
    public static boolean issafe(int index, int m, int conf[][], int[][]sdegrees, int[][]timeslot){
	for(int i=0; i<sdegrees.length;i++)
		if(conf[sdegrees[index][0]-1][i]!=0 && timeslot[i][1] == m)
                    return false;
        return true;
    }
    
    public static void export(int[][]timeslot, String filename){
        try{    
            FileWriter fw=new FileWriter("D:\\"+filename+".sol");    
            for (int i = 0; i <timeslot.length; i++) {
                for (int j = 0; j <timeslot[i].length; j++) {
                      fw.write(timeslot[i][j]+ " ");
                }
                fw.write("\n");  
            }
             
            fw.close();    
        } catch(Exception e){
        	System.out.println(e);
        }    
            System.out.println("File "+filename+".sol berhasil disimpan di D");    
    }
    
}