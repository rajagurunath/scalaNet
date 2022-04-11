package customNet.nn

import customNet.Tensor.CustomTensor
import customNet.layers.{Layer, Linear}

import scala.collection.mutable
import scala.collection.mutable.Iterable

case class NN(layers:List[Layer]) extends Serializable{


  def forward(inputs:CustomTensor):CustomTensor = {

    // var since inputs are immutable , i am there are better ways to handle this
    var local_inputs = inputs
    for(layer<-layers){

      local_inputs = layer.forward(local_inputs)

    }
  local_inputs
  }

    def backward(grad:CustomTensor):CustomTensor ={

      val revLayers = layers.reverse
      // var since inputs are immutable , i am there are better ways to handle this
      var local_grads = grad
      for (layer<- revLayers){
        local_grads = layer.backward(local_grads)

      }
      local_grads
    }

    def params_grads():List[Iterable[(CustomTensor, CustomTensor)]]={
        val keys = layers.head.params.keys
        for (layer<-layers) yield {
          for (key <- keys) yield {
               val p = layer.params.get(key = key)
               val g = layer.grads.get(key = key)

              (p.asInstanceOf[CustomTensor], g.asInstanceOf[CustomTensor])
            }

        }

    }

}
