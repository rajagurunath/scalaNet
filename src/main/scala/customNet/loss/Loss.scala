package customNet.loss
import botkop.{numsca=>np}
import customNet.Tensor.CustomTensor

case class Loss(){

  def loss(predicted:CustomTensor,actual:CustomTensor):Double = ???

  def grad(predicted:CustomTensor,actual:CustomTensor):CustomTensor = ???

}


case class MSE() extends Loss(){

  def square(x:CustomTensor):CustomTensor={

    val res = x*x
    res.asInstanceOf[CustomTensor]
  }

  override def loss(predicted: CustomTensor, actual: CustomTensor): Double ={
    val res1= predicted-actual
    val res = square(res1.asInstanceOf[CustomTensor])
     np.sum(res)
  }

  override def grad(predicted: CustomTensor, actual: CustomTensor): CustomTensor={

    val res =  2*(predicted-actual)
    res.asInstanceOf[CustomTensor]
  }

}

