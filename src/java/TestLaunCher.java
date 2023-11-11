
import businesslayer.PeerTutorBusinessLogic;
import java.util.List;
import transferobject.PeerTutor;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author pdstu
 */
public class TestLaunCher {
     public static void main(String[] args) {
        try {
            PeerTutorBusinessLogic logic = new PeerTutorBusinessLogic();
            List<PeerTutor> list = null;
            List<String> gradeList = List.of("A", "A+", "A-");
            PeerTutor peerTutor = null;
            String courseCode = null;
                    
//            System.out.println("Printing PeerTutors");
//            list = logic.getAllPeerTutorsForCourse("CST8101");
//            printPeerTutors(list);
//            System.out.println();
//            
//            System.out.println("Printing isPeerTutorRegistered");
//            peerTutor = new PeerTutor();
//            peerTutor.setLastName("Horsecollar");
//            peerTutor.setFirstName("Horace");
//            System.out.println("Horsecollar"+"Horace "+logic.isPeerTutorRegistered(peerTutor));
//            peerTutor.setLastName("AAA");
//            peerTutor.setFirstName("BBB");
//            System.out.println("AAA"+"BBB"+logic.isPeerTutorRegistered(peerTutor));
//            System.out.println();
//            
//            System.out.println("Printing isCourseValid");
//            System.out.println("CST8999"+logic.isCourseValid("CST8999"));
//            System.out.println("CST8101"+logic.isCourseValid("CST8101"));
//            System.out.println();
//            
//            
//            System.out.println("Printing hasPeerTutorTakenCourse");
//            peerTutor = new PeerTutor();
//            peerTutor.setLastName("Duck");
//            peerTutor.setFirstName("Daisy");
//            System.out.println("CST8101"+logic.hasPeerTutorTakenCourse(peerTutor, "CST8101"));
//            System.out.println("CST8110"+logic.hasPeerTutorTakenCourse(peerTutor,"CST8110"));
//            System.out.println();
//            
//            System.out.println("Printing getPeerTutorLetterGradeForCourse");
//            peerTutor = new PeerTutor();
//            peerTutor.setLastName("Cow");
//            peerTutor.setFirstName("Clarabelle");
//            System.out.println("CST8101 Cow grade: "+logic.getPeerTutorLetterGradeForCourse(peerTutor,"CST8101"));
//            peerTutor.setLastName("McDuck");
//            peerTutor.setFirstName("Scrooge");
//            System.out.println("CST8101 McDuck grade: "+logic.getPeerTutorLetterGradeForCourse(peerTutor,"CST8101"));
//            System.out.println();
//            
//            System.out.println("Printing isCourseAlreadyAssignedToPeerTutor");
//            peerTutor = new PeerTutor();
//            peerTutor.setLastName("McDuck");
//            peerTutor.setFirstName("Scrooge");
//            System.out.println("CST8101 McDuck assigned: "+logic.isCourseAlreadyAssignedToPeerTutor(peerTutor,"CST8101"));
//            peerTutor.setLastName("Horsecollar");
//            peerTutor.setFirstName("Horace");
//            System.out.println("CST8101 Horsecollar assigned: "+logic.isCourseAlreadyAssignedToPeerTutor(peerTutor,"CST8101"));
//            System.out.println();
// 
//            System.out.println("Printing allPeerTutors");
//            list = logic.getAllPeerTutorsForCourse("CST8101");
//            printPeerTutors(list);
//            System.out.println();
            
            
            System.out.println("Printing all logic");
            peerTutor = new PeerTutor();
            peerTutor.setLastName("McDuck");
            peerTutor.setFirstName("Scrooge");
            peerTutor.setPeerTutorID(logic.getPeerTutorID(peerTutor));
            courseCode = "CST8101";
//            if(!logic.isPeerTutorRegistered(peerTutor)){
//                System.out.println("not registered");
//            }
//            else if (!logic.isCourseValid(courseCode)){
//                System.out.println("course not valid");
//            }
//            else if (!logic.hasPeerTutorTakenCourse(peerTutor, courseCode)){
//                System.out.println("course not taken");
//            }
//            else if (!gradeList.contains(logic.getPeerTutorLetterGradeForCourse(peerTutor, courseCode))){
//                System.out.println("grade too low");
//            }
//            else if (logic.isCourseAlreadyAssignedToPeerTutor(peerTutor, courseCode)){
//                System.out.println("already assigned");
//            }
//            else{
//                logic.assignCourseToPeerTutor(peerTutor, courseCode);
//                list = logic.getAllPeerTutorsForCourse(courseCode);
//                for (PeerTutor tutor : list){
//                    System.out.println(tutor.getFirstName()+", " +tutor.getLastName());
//                }
//                System.out.println("inserted");
//            }
            
            logic.deletePeerTutor(peerTutor);
            list = logic.getAllPeerTutorsForCourse(courseCode);
               for (PeerTutor tutor : list){
                    System.out.println(tutor.getFirstName()+", " +tutor.getLastName());
                }
            System.out.println("deleted");

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }

    /**
     * Prints the details of a single receiver.
     *
     * @param receiver The `ReceiverDTO` object representing the receiver to be
     * printed.
     */
    private static void printPeerTutor(PeerTutor peerTutor) {
        String output = String.format("%d, %s, %s",
                peerTutor.getPeerTutorID(),
                peerTutor.getLastName(),
                peerTutor.getFirstName());

        System.out.println(output);
    }

    /**
     * Prints the details of a list of receivers.
     *
     * @param receivers The list of `ReceiverDTO` objects representing the
     * receivers to be printed.
     */
    private static void printPeerTutors(List<PeerTutor> peerTutors) {
	    for(PeerTutor peerTutor : peerTutors){
	    	printPeerTutor(peerTutor);
	    }

//        for (int i = receivers.size() - 6; i < receivers.size(); i++) {
//            printReceiver(receivers.get(i));
//        }
//        System.out.println();
    }
    
}
