def array_diff(a, b):
  c = []
  for item in a:
    if item not in b:
      c.append(item)
  return c