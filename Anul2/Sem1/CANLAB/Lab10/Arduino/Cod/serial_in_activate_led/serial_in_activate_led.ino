void setup() {
  // put your setup code here, to run once:
  pinMode(13, OUTPUT);
  Serial.begin(9600);
  Serial.println("Input:\n 1 for LED ON\n 0 for LED OFF");
}

void loop() {
  // put your main code here, to run repeatedly:
  if(Serial.available() > 0)
  {
    char state = Serial.read();
    if (state == '1')
    {
    digitalWrite(13, HIGH);
    Serial.println("LED --> ON");
    }
  if (state == '0')
  {
    digitalWrite(13, LOW);
    Serial.println("LED --> OFF");
  }
  }
}
