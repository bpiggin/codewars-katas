def to_camel_case(text):
  nextUpper = False
  newStr = ""
  for char in text:
    if (char == "-" or char == "_"):
      nextUpper = True
      continue
    if (nextUpper):
      newStr += char.upper()
      nextUpper = False
    else:
      newStr += char
  return newStr