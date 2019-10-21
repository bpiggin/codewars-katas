func findMissingLetter(_ chArr: [Character]) -> Character 
{
  for index in 0..<chArr.count
  {
    let currentCharUnicodeValue = getUnicodeValue(chArr[index])
    let nextCharUnicodeValue = getUnicodeValue(chArr[index + 1])
    
    if nextCharUnicodeValue != currentCharUnicodeValue + 1
    {
      return Character(UnicodeScalar(currentCharUnicodeValue + 1)!)
    }
  }
  return "Z" //Should never happen.
}

func getUnicodeValue(_ char: Character) -> Int
{
    let scalars = char.unicodeScalars
    let firstScalar = scalars[scalars.startIndex]
    return Int(firstScalar.value)
}
