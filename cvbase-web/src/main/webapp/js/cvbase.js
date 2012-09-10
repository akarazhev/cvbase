/*
 * Copyright (c) 2012. CV Base Application.
 *
 * This file is part of CV Base Application. CV Base Application is free software:
 * you can redistribute it and/or modify it under the terms of the
 * GNU General Public License as published by the Free Software Foundation,
 * either version 3 of the License, or (at your option) any later version.
 */

/**
 * This is a CV Base java script file.
 *
 * @author Andrej Karazhev
 * @version 1.0.0
 */

/**
 * This method sets a right direction depending on user decision 
 * (i. go to Next or Prev page).
 * 
 * @param command is a selected command.
 */
function setCommand(command)
{
    document.getElementById("cmd").value = command;
}

/*
 * This method is called when user trys to delete profile.
 * 
 * @param id is attribute identifier of tag.
 */
function confirmDelete(id)
{
    var result = confirm("Do you want to delete the profile?");
    if (result != true)
    {
        // Disable the link
        document.getElementById(id).setAttribute("href", "");
    }
}
