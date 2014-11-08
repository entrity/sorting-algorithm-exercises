class MyBinarySearchTree

  def add o
    if @root
      @root.add(o)
    else
      @root = Node.new(o)
    end
  end

  def each &block
    @root.each &block
  end

end

class Node
  attr_accessor :left, :right, :val

  def initialize val
    self.val = val
  end

  def add o
    if o > val
      right ? right.add(o) : self.right = Node.new(o)
    else
      left  ? left.add(o)  : self.left  = Node.new(o)
    end
  end

  def each &block
    left  && left.each(&block)
    yield val
    right && right.each(&block)
  end

end


def tree_sort arr
  tree = MyBinarySearchTree.new
  arr.each{|o| tree.add(o) }
  arr.clear
  tree.each{|n| arr.push(n) }
  arr
end

def simple_test
  puts tree_sort([10,25,37,30,23]).inspect
end
