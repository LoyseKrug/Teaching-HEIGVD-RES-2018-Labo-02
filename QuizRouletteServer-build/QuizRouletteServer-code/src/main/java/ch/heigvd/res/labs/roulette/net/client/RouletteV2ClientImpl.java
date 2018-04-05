package ch.heigvd.res.labs.roulette.net.client;

import ch.heigvd.res.labs.roulette.data.EmptyStoreException;
import ch.heigvd.res.labs.roulette.data.JsonObjectMapper;
import ch.heigvd.res.labs.roulette.data.Student;
import ch.heigvd.res.labs.roulette.data.StudentsList;
import ch.heigvd.res.labs.roulette.net.protocol.RouletteV1Protocol;
import ch.heigvd.res.labs.roulette.net.protocol.RouletteV2Protocol;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class implements the client side of the protocol specification (version 2).
 *
 * @author Olivier Liechti
 */
public class RouletteV2ClientImpl extends RouletteV1ClientImpl implements IRouletteV2Client {


  private static final Logger LOG = Logger.getLogger(RouletteV1ClientImpl.class.getName());

  @Override
  public void clearDataStore() throws IOException {

      if(socket != null && socket.isConnected()){

          Student student = new Student();

          printWriter.println(RouletteV2Protocol.CMD_CLEAR);   // get random student
          printWriter.flush();

          student.setFullname(bufferedReader.readLine());
      } else {
          LOG.log(Level.SEVERE, "Not conected to server.");
          throw new IOException();
      }
  }

  @Override
  public List<Student> listStudents() throws IOException {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public int getNumberOfCommands(){
    return 0;
  }

  @Override
  public int getNumberOfStudentAdded(){
    return 0;
  }
}
