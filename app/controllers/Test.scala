package controllers

/**
 * Created by cirrusdi on 11/20/15.
 */

import play.api.mvc.{Action, Controller}

class Test extends Controller{

   def test(id:String,value:String) = Action{
     Ok(id+"  "+value)
   }

 }
