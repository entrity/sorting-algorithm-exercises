class Heap < Array

	def push! o
		push(o)
		if length > 1
			compare_to_parent_and_swap_if_necessary length-1
		end
	end

	def pop_smallest!
		output = self[0]
		last = pop
		if length > 0
			self[0] = last
			compare_to_children_and_swap_if_necessary 0
		end
		return output
	end

	def compare_to_parent_and_swap_if_necessary i
		parent_i = (i - 1) / 2
		if parent_i >= 0 && self[i] < self[parent_i]
			tmp = self[i]
			self[i] = self[parent_i]
			self[parent_i] = tmp
			compare_to_parent_and_swap_if_necessary parent_i
		end
	end

	def compare_to_children_and_swap_if_necessary i
		lchild_i = i * 2 + 1
		rchild_i = lchild_i + 1
		swap_child_i = 
		if lchild_i < length && self[i] > self[lchild_i]
			lchild_i
		elsif rchild_i < length && self[i] > self[rchild_i]
			rchild_i
		end
		if swap_child_i
			tmp = self[i]
			self[i] = self[swap_child_i]
			self[swap_child_i] = tmp
			compare_to_children_and_swap_if_necessary swap_child_i
		end
	end

end

def heap_sort arr
	h = Heap.new
	arr.each{|o| h.push! o }
	arr.clear
	while !h.empty?
		arr.push h.pop_smallest!
	end
	arr
end

def simple_test
	puts heap_sort([10,25,37,30,23]).inspect
end
