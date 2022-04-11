package customNet.layers
import botkop.{numsca => np}
import customNet.Tensor.CustomTensor

import scala.collection.mutable
import scala.collection.mutable.{HashMap, Iterable}

case class Layer(params:HashMap[String,CustomTensor],
                 grads:HashMap[String,CustomTensor]){

  def apply(grads: HashMap[String, CustomTensor], value: HashMap[Nothing, Nothing]): Unit = ???
//
//  def this(params:HashMap[String,CustomTensor], grads:HashMap[String,CustomTensor] ){
//
//    this(params,HashMap());
//    this(grads,HashMap());
//
//  }
  def forward(inputs:CustomTensor): CustomTensor = ???

  def backward(grad:CustomTensor):CustomTensor = ???

//  def params_grads():List[mutable.Iterable[(CustomTensor, CustomTensor)]]= ???
//
}

case class Linear(weights:CustomTensor, bias: CustomTensor) extends Layer(params = HashMap(),grads = HashMap()){

  override def forward(inputs: CustomTensor): CustomTensor ={
    params += ("w"->weights)
    params += ("b" -> bias)
    params += ("inputs" -> inputs)
    val res = inputs*weights + bias
    res.asInstanceOf[CustomTensor]
  }

  override def backward(grad: CustomTensor): CustomTensor = {
    /*
    self.grads["b"] = np.sum(grad, axis=0)
    self.grads["w"] = self.inputs.T @ grad
    return grad @ self.params["w"].T
     */


    grads += ("b" -> np.sum(grad, axis = 0).asInstanceOf[CustomTensor])
    grads += ("w" -> params("inputs").dot(grad).asInstanceOf[CustomTensor])
    val res = grad.dot(params("w").T)
    res.asInstanceOf[CustomTensor]
  }


}


object Linear{

  def apply(input_size:Int,output_size:Int): Linear ={
    val w1 = np.randn(input_size,output_size)
    val weights = w1.asInstanceOf[CustomTensor]
    val b1 = np.randn(output_size)
    val bias = b1.asInstanceOf[CustomTensor]
    Linear(weights,bias)
  }

}
