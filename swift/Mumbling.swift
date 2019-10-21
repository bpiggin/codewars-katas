func accum(_ s: String) -> String 
{
  var result : String  = ""
  
  let charArray = Array(s.characters) //Make array of characters
  for i in 0..<charArray.count //Loop through them
  {
    let str1 = String(charArray[i]).capitalized //First is capitalised
    let str2 = String(repeating: String(charArray[i]).lowercased(), count: i) //Rest are lowercase and there are i of them
    var str3 = str1 + str2 //Append them
    
    if i < charArray.count - 1 //Add a dash if we are not the last character
    {
      str3 = str3 + "-"
    }
    result = result + str3 //Add this to the result
  }
  
  return result
}