/* 
 * Copyright 2015 Len Payne <len.payne@lambtoncollege.ca>.
 * Updated 2015 Mark Russell <mark.russell@lambtoncollege.ca>
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

function refreshContent() {
    $.ajax({
       url: 'note',
       method: 'GET',                   
       success: function(data) {
           $('#content').text(data);
       }
    });
}
function addNote() {
    $.ajax({
       url: 'note',
       method: 'POST',
       data: { 'addNote' : $('#addNote').val()},
       success: refreshContent
    });
}
function setNote() {
    $.ajax({
       url: 'note',
       method: 'POST',
       data: { 'setNote' : $('#setNote').val()},
       success: refreshContent
    });
}
function clearNote() {
    $.ajax({
       url: 'note',
       method: 'POST',
       data: { 'clear' : true },
       success: refreshContent
    });
}