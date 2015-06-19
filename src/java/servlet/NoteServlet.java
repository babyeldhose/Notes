/*
 * Copyright 2015 Len Payne <len.payne@lambtoncollege.ca>.
 * Updated 2015 Mark Russell <mark.russell@lambtoncollege.ca>s
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Note;

/**
 * Provides an Account Balance and Basic Withdrawal/Deposit Operations
 */
@WebServlet("/note")
public class NoteServlet extends HttpServlet {

   
 Note note = new Note();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        
        try (PrintWriter out = response.getWriter()) {

            String bal = note.getNote();
            out.println(bal);

        } catch (IOException ex) {
            System.err.println(ex.getMessage());

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
          String setting="";
          String adding="";
          String clear="";
          setting=request.getParameter("setNote");
          adding=request.getParameter("addNote");
          clear=request.getParameter("clear");
          
            if (adding != null) {   
            //out.println(n);
                note.addNote(adding);
            }
            else if (setting != null) {
                note.setNote(setting);
            }
            else if (clear != null) {
                note.clear();
            }
            
        } catch (Exception ex) {
            Logger.getLogger(NoteServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
