/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package threephasecommit;

/**
 *
 * @author jianyu
 */
public class test05 {
    public static void main(String[] args) {
        ParticipantProcess participant = new ParticipantProcess("config5.txt");
        //participant.CoordinatorCommitProtocol();
        participant.ProcessStartProtocol();
        //participant.ParticipantCommitProtocol();
        participant.playList.printPlayList();
    }
}
