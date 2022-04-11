package customNet.optim
import customNet.nn.NN


case class Optimizer(){

  def step(net:NN) = ???
}


case class SGD() extends Optimizer(){

  override def step(net: NN): Nothing = {


  }

}