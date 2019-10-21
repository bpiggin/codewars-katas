func solution(_ num: Int) -> Int 
{
  var sum = 0
  for index in 0..<num
  {
    if index % 3 == 0 || index % 5 == 0
    {
      sum = sum + index
    }
  }
  return sum
}